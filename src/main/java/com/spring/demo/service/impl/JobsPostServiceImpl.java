package com.spring.demo.service.impl;

import com.spring.demo.entity.JobPostingEntity;
import com.spring.demo.entity.UsersEntity;
import com.spring.demo.model.JobsPostResponse;
import com.spring.demo.repository.IJobApplicationRepository;
import com.spring.demo.repository.IJobsPostRepository;
import com.spring.demo.repository.IMyWordRepository;
import com.spring.demo.repository.IUserRepository;
import com.spring.demo.service.ICategoryService;
import com.spring.demo.service.IJobsPostService;
import com.spring.demo.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsPostServiceImpl implements IJobsPostService {
    @Autowired
    IJobsPostRepository postRepository;
    @Autowired
    IJobApplicationRepository applicationRepository;
    @Autowired
    IMyWordRepository wordRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    ICategoryService categoryService;

    @Override
    public List<JobPostingEntity> findAllJobsPost() {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        return usersEntity.getJobPostings();
    }

    @Override
    public JobPostingEntity finJobsPostById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public JobPostingEntity PostJob(JobPostingEntity posting) {
        try {
            posting.setCreatedAt(finJobsPostById(posting.getId()).getCreatedAt());
            postRepository.save(posting);
            System.out.println("Post Job Success!");
        } catch (Exception e) {
            System.err.println("Post Job Fail!");
            return null;
        }
        return posting;
    }

    @Override
    public List<JobPostingEntity> DeleteById(int[] id) {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        for (var job_id : id) {
            JobPostingEntity post = postRepository.findById(job_id).orElse(null);
            if (post.getJobPostUser().getId() == usersEntity.getId()) {
                for (var job_app : applicationRepository.findByReJobId(job_id)) {
                    wordRepository.deleteByJobApplicationId(job_app.getId());
                }
                applicationRepository.deleteByReJobId(job_id);
                postRepository.deleteById(job_id);
            }
        }
        return postRepository.findAll();
    }

    @Override
    public JobPostingEntity updateByIdAndStatus(int id, byte status) {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        JobPostingEntity postingEntity = postRepository.findById(id).orElse(null);
        if (postingEntity.getJobPostUser().getId() == usersEntity.getId()) {
            postRepository.updateByIdAndStatus(id, status);
            return postRepository.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public JobPostingEntity convertFromJobsPostResponse(JobsPostResponse p) {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        JobPostingEntity postingEntity = new JobPostingEntity();
        postingEntity.setTitle(p.getTitle());
        postingEntity.setFirstPrice(p.getFirstPrice());
        postingEntity.setLastPrice(p.getLastPrice());
        postingEntity.setContent(p.getContent());
        postingEntity.setLat(p.getLat());
        postingEntity.setLon(p.getLon());
        postingEntity.setTimeRemating(p.getTimeRemating());
        postingEntity.setCategory(categoryService.findCateById(p.getCateId()));
        postingEntity.setJobPostUser(usersEntity);
        return postingEntity;
    }
}
