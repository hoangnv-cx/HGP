package com.spring.demo.service.impl;

import com.spring.demo.entity.JobApplicationEntity;
import com.spring.demo.entity.MyWorkEntity;
import com.spring.demo.entity.UsersEntity;
import com.spring.demo.model.MyWordResponse;
import com.spring.demo.repository.IJobApplicationRepository;
import com.spring.demo.repository.IMyWordRepository;
import com.spring.demo.repository.IUserRepository;
import com.spring.demo.service.IMyWordService;
import com.spring.demo.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyWordImpl implements IMyWordService {
    @Autowired
    IMyWordRepository wordRepository;
    @Autowired
    IJobApplicationRepository applicationRepository;
    @Autowired
    IUserRepository userRepository;

    @Override
    public List<MyWorkEntity> findAllMyWord() {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        List<JobApplicationEntity> data = usersEntity.getJobApplications();
        List<MyWorkEntity> list = new ArrayList<>();
        for (var applicationJob : data) {
            list.add(applicationJob.getMyWork());
        }
        return list;
    }

    @Override
    public MyWorkEntity findMyWordById(int id) {
        return wordRepository.findById(id).get();
    }

    @Override
    public MyWorkEntity addMyWord(MyWorkEntity myWork) {
        applicationRepository.updateByIdAndStatus(myWork.getJobApplication().getId(), (byte) 1);
        return wordRepository.save(myWork);
    }

    @Override
    public MyWorkEntity updateByIdAndStatus(int id, byte status) {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        JobApplicationEntity jobApp = applicationRepository.findByMyWorkId(id);
        if (jobApp.getUsersJobApplication().getId() == usersEntity.getId()) {
            wordRepository.updateByIdAndStatus(id, status);
            return wordRepository.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public void DeleteById(int[] id) {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        for (var job_id : id) {
            JobApplicationEntity jobApp = applicationRepository.findByMyWorkId(job_id);
            if (jobApp.getUsersJobApplication().getId() == usersEntity.getId()) {
                try {
                    wordRepository.deleteById(job_id);
                } catch (Exception e) {
                    System.err.println("Remove my word fail!");
                }
            }
        }
    }

    @Override
    public MyWorkEntity convertFromMyWordResponse(MyWordResponse wordResponse) {
        MyWorkEntity workEntity = new MyWorkEntity();
        workEntity.setStatus(wordResponse.getStatus());
        workEntity.setJobApplication(applicationRepository.findById(wordResponse.getJobApplicationId()).orElse(null));
        return workEntity;
    }
}
