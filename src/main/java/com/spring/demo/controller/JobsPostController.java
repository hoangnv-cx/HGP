package com.spring.demo.controller;

import com.spring.demo.entity.JobPostingEntity;
import com.spring.demo.model.JobsPostResponse;
import com.spring.demo.model.SearchJobsPostResponse;
import com.spring.demo.model.StatusResponse;
import com.spring.demo.service.IJobsPostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/jobs")
@Tag(name = "Job Posting Api")
public class JobsPostController {

    @Autowired
    IJobsPostService postService;

    @GetMapping("/post")
    public List<JobPostingEntity> viewJobPost() {
        return postService.findAllJobsPost();
    }

    @PostMapping("/post")
    public JobPostingEntity postJob(@RequestBody JobsPostResponse jobsPostResponse) {
        return postService.PostJob(postService.convertFromJobsPostResponse(jobsPostResponse));
    }

    @PutMapping("/post")
    public JobPostingEntity updateJobPost(@RequestBody JobPostingEntity jobPostingEntity) {
        return postService.PostJob(jobPostingEntity);
    }

    @PutMapping("/post/status")
    public JobPostingEntity updateStatusJobPost(@RequestBody StatusResponse statusResponse) {
        return postService.updateByIdAndStatus(statusResponse.getEntityId(), statusResponse.getStatus());
    }

    @DeleteMapping("/post")
    public List<JobPostingEntity> deleteJobPost(@RequestBody int[] id) {
        postService.DeleteById(id);
        return postService.findAllJobsPost();
    }


}
