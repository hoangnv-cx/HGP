package com.spring.demo.service;

import com.spring.demo.entity.JobPostingEntity;

import java.util.Date;
import java.util.List;

public interface IJobsService {
    List<JobPostingEntity> findAllJobs();

    List<JobPostingEntity> findJobsByPriceAndDate(double firstPrice, double lastPrice, Date date);

    List<JobPostingEntity> findWishlistJobs();

    List<JobPostingEntity> findJobsByTitle(String title);

    List<JobPostingEntity> findJobsByCategoryId(int id);
}
