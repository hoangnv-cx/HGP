package com.spring.demo.controller;

import com.spring.demo.entity.ReviewsEntity;
import com.spring.demo.service.IReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Reviews Api")
public class ReviewsController {
    @Autowired
    IReviewService reviewService;

    @GetMapping("/reviews")
    public List<ReviewsEntity> findAllReviews() {
        return reviewService.findAllReviews();
    }

    @PostMapping("/reviews")
    public ReviewsEntity addReviews(@RequestBody ReviewsEntity reviews) {
        return reviewService.addReviews(reviews);
    }

    @PutMapping("/reviews")
    public ReviewsEntity updateReviews(@RequestBody ReviewsEntity reviews) {
        return reviewService.addReviews(reviews);
    }

    @DeleteMapping("/reviews")
    public ReviewsEntity deleteReviews(@RequestBody ReviewsEntity reviews) {
        return reviewService.deleteReviews(reviews);
    }

    @GetMapping("/to-be-evaluated")
    public List<ReviewsEntity> findAllToBeEvaluated() {
        return reviewService.findAllToBeEvaluated();
    }

}
