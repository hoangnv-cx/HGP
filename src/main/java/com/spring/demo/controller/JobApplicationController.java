package com.spring.demo.controller;

import com.spring.demo.entity.JobApplicationEntity;
import com.spring.demo.model.JobApplicationResponse;
import com.spring.demo.model.StatusResponse;
import com.spring.demo.service.IFileUploadService;
import com.spring.demo.service.IJobApplicationService;
import com.spring.demo.service.IJobsPostService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/api/jobs")
@Tag(name = "Job Application Api")
public class JobApplicationController {
    @Autowired
    IJobApplicationService jobApplicationService;
    @Autowired
    IFileUploadService uploadService;

    @GetMapping("/application")
    public List<JobApplicationEntity> viewAllJobApplication() {
        return jobApplicationService.findAllJobsApplication();
    }

    @PostMapping(value = "/application", consumes = {"multipart/form-data"})
    public JobApplicationEntity applicationJob(@ModelAttribute JobApplicationResponse response) {
        JobApplicationEntity jobApplication = jobApplicationService.convertFromResponse(response);
        MultipartFile file = response.getPhoto();
        return jobApplicationService.applicationJob(jobApplication, file);
    }

    @PutMapping(value = "/application", consumes = {"multipart/form-data"})
    public JobApplicationEntity updateApplicationJob(@ModelAttribute JobApplicationResponse response) {
        JobApplicationEntity jobApplication = jobApplicationService.convertFromResponse(response);
        MultipartFile file = response.getPhoto();
        return jobApplicationService.applicationJob(jobApplication, file);
    }

    @PutMapping("/application/status")
    public JobApplicationEntity updateStatusApplicationJob(@RequestBody StatusResponse statusResponse) {
        return jobApplicationService.updateByIdAndStatus(statusResponse.getEntityId(), statusResponse.getStatus());
    }

    @DeleteMapping("application")
    public List<JobApplicationEntity> listBackJobApplication(@RequestBody int[] id) {
        jobApplicationService.DeleteById(id);
        return jobApplicationService.findAllJobsApplication();
    }

    @GetMapping("/uploads/{photo}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable @Parameter(example = "1618219444140_Nguyen-Ba-Phuc-TopCV.vn-080321.85451.pdf") String photo) {
        return uploadService.getImage(photo);
    }
}
