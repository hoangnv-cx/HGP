package com.spring.demo.service;

import com.spring.demo.entity.ReviewsEntity;

import java.util.List;

public interface IReviewService {
    List<ReviewsEntity> findAllReviews();
    List<ReviewsEntity> findAllToBeEvaluated();
    ReviewsEntity addReviews(ReviewsEntity reviews);
    ReviewsEntity deleteReviews(ReviewsEntity reviewsEntity);
}
