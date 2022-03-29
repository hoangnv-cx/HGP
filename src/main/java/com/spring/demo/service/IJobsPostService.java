package com.spring.demo.service;

import com.spring.demo.entity.JobPostingEntity;
import com.spring.demo.model.JobsPostResponse;

import java.util.Date;
import java.util.List;

public interface IJobsPostService {

    List<JobPostingEntity> findAllJobsPost();

    JobPostingEntity finJobsPostById(int id);

    JobPostingEntity PostJob(JobPostingEntity posting);

    List<JobPostingEntity> DeleteById(int[] id);

    JobPostingEntity updateByIdAndStatus(int id, byte status);

    JobPostingEntity convertFromJobsPostResponse(JobsPostResponse postResponse);
}
