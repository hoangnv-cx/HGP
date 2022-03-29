package com.spring.demo.controller;

import com.spring.demo.entity.JobPostingEntity;
import com.spring.demo.model.SearchJobsPostResponse;
import com.spring.demo.service.IJobsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/jobs")
@Tag(name = "Search Jobs Api")
public class SearchJobsController {

    @Autowired
    IJobsService jobsService;

    @GetMapping("/search")
    public List<JobPostingEntity> searchJobs() {
        return jobsService.findAllJobs();
    }

    @PostMapping("/search")
    public List<JobPostingEntity> searchJobsPost(@RequestBody SearchJobsPostResponse searchJobs) {
        return jobsService.findJobsByPriceAndDate(searchJobs.getFirstPrice(), searchJobs.getLastPrice(), searchJobs.getDate());
    }

    @PostMapping("/search/title")
    public List<JobPostingEntity> searchJobsPostByTitle(@RequestBody SearchJobsPostResponse searchJobs) {
        return jobsService.findJobsByTitle(searchJobs.getTitle());
    }

    @PostMapping("/search/cate-id")
    public List<JobPostingEntity> searchJobsPostByCateId(@RequestBody SearchJobsPostResponse searchJobs) {
        return jobsService.findJobsByCategoryId(searchJobs.getCateId());
    }

    @GetMapping("/search/wish-list")
    public List<JobPostingEntity> viewWishlistJobs() {
        return jobsService.findWishlistJobs();
    }
}
