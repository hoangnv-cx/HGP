package com.spring.demo.service;

import com.spring.demo.entity.JobApplicationEntity;
import com.spring.demo.model.JobApplicationResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IJobApplicationService {
    List<JobApplicationEntity> findAllJobsApplication();

    JobApplicationEntity findJobApplicationById(int id);

    JobApplicationEntity findJobAppByMyWorkId(int myWorkId);

    JobApplicationEntity applicationJob(JobApplicationEntity jobApplication, MultipartFile photo);

    JobApplicationEntity updateByIdAndStatus(int id, byte status);

    void DeleteById(int[] id);

    JobApplicationEntity convertFromResponse(JobApplicationResponse response);
}
