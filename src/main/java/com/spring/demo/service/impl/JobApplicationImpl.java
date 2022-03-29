package com.spring.demo.service.impl;

import com.spring.demo.entity.JobApplicationEntity;
import com.spring.demo.entity.JobPostingEntity;
import com.spring.demo.entity.UsersEntity;
import com.spring.demo.model.JobApplicationResponse;
import com.spring.demo.repository.IJobApplicationRepository;
import com.spring.demo.repository.IMyWordRepository;
import com.spring.demo.repository.IUserRepository;
import com.spring.demo.service.IFileUploadService;
import com.spring.demo.service.IJobApplicationService;
import com.spring.demo.service.IJobsPostService;
import com.spring.demo.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class JobApplicationImpl implements IJobApplicationService {
    @Autowired
    IJobsPostService postService;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IJobApplicationRepository applicationRepository;
    @Autowired
    IMyWordRepository wordRepository;
    @Autowired
    IFileUploadService fileUploadService;

    @Override
    public List<JobApplicationEntity> findAllJobsApplication() {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        return usersEntity.getJobApplications();
    }

    @Override
    public JobApplicationEntity findJobApplicationById(int id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @Override
    public JobApplicationEntity findJobAppByMyWorkId(int myWorkId) {
        return applicationRepository.findByMyWorkId(myWorkId);
    }

    @Override
    public JobApplicationEntity applicationJob(JobApplicationEntity jobApplication, MultipartFile photo) {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        Date date = new Date();
        if (jobApplication.getUsersJobApplication() == null && jobApplication.getReJob().getTimeRemating().compareTo(date) > 0) {
            String fileName = fileUploadService.storeFile(photo);
            if (fileName.length() > 0) {
                jobApplication.setFileName(fileName);
                jobApplication.setUsersJobApplication(usersEntity);
                return applicationRepository.save(jobApplication);
            }
        }
        return null;
    }

    @Override
    public JobApplicationEntity updateByIdAndStatus(int id, byte status) {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        JobApplicationEntity jobApp = applicationRepository.findById(id).orElse(null);
        if (jobApp.getUsersJobApplication().getId() == usersEntity.getId()) {
            applicationRepository.updateByIdAndStatus(id, status);
            return applicationRepository.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public void DeleteById(int[] id) {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        for (var job_id : id) {
            for (var job_app : usersEntity.getJobApplications()) {
                if (job_id == job_app.getId()) {
                    try {
                        wordRepository.deleteByJobApplicationId(job_id);
                        applicationRepository.deleteById(job_id);
                    } catch (Exception e) {
                        System.err.println("Remove job application fail!");
                    }
                }
            }
        }
    }

    @Override
    public JobApplicationEntity convertFromResponse(JobApplicationResponse response) {
        JobApplicationEntity jobApplicationEntity = new JobApplicationEntity();
        jobApplicationEntity.setId(response.getId());
        jobApplicationEntity.setMyBid(response.getMyBid());
        jobApplicationEntity.setDescription(response.getDescription());
        jobApplicationEntity.setReJob(postService.finJobsPostById(response.getJobId()));
        return jobApplicationEntity;
    }
}
