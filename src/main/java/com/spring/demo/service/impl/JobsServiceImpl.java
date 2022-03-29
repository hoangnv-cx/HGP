package com.spring.demo.service.impl;

import com.spring.demo.entity.CategoriesEntity;
import com.spring.demo.entity.JobPostingEntity;
import com.spring.demo.entity.UsersEntity;
import com.spring.demo.repository.IJobsPostRepository;
import com.spring.demo.repository.IUserRepository;
import com.spring.demo.service.IJobsService;
import com.spring.demo.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JobsServiceImpl implements IJobsService {
    @Autowired
    IJobsPostRepository postRepository;
    @Autowired
    IUserRepository userRepository;

    @Override
    public List<JobPostingEntity> findAllJobs() {
        return postRepository.findAll();
    }

    @Override
    public List<JobPostingEntity> findJobsByPriceAndDate(double firstPrice, double lastPrice, Date date) {
        return postRepository.findByPrice(firstPrice, lastPrice, date);
    }

    @Override
    public List<JobPostingEntity> findWishlistJobs() {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        List<CategoriesEntity> data = usersEntity.getMySkills();
        List<JobPostingEntity> list = new ArrayList<>();
        for (var cate : data) {
            list.addAll(postRepository.findWishlistJobs(cate.getId()));
        }
        return list;
    }

    @Override
    public List<JobPostingEntity> findJobsByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public List<JobPostingEntity> findJobsByCategoryId(int id) {
        return postRepository.findByCategoryId(id);
    }
}
