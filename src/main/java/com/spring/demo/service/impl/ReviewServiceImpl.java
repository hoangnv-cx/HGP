package com.spring.demo.service.impl;

import com.spring.demo.entity.ReviewsEntity;
import com.spring.demo.entity.UsersEntity;
import com.spring.demo.repository.IReviewRepository;
import com.spring.demo.repository.IUserRepository;
import com.spring.demo.service.IReviewService;
import com.spring.demo.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements IReviewService {
    @Autowired
    IReviewRepository reviewRepository;
    @Autowired
    IUserRepository userRepository;

    @Override
    public List<ReviewsEntity> findAllReviews() {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        return usersEntity.getEmlpoyeeReviews();
    }

    @Override
    public List<ReviewsEntity> findAllToBeEvaluated() {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        return usersEntity.getCustomReviews();
    }

    @Override
    public ReviewsEntity addReviews(ReviewsEntity reviews) {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        if (reviews.getEmployee().getId() == usersEntity.getId()) {
            return reviewRepository.save(reviews);
        }
        return null;
    }

    @Override
    public ReviewsEntity deleteReviews(ReviewsEntity reviewsEntity) {
        UsersEntity usersEntity = userRepository.findByUserName(SecurityUtils.getName());
        if (reviewsEntity.getEmployee().getId() == usersEntity.getId()) {
            reviewRepository.delete(reviewsEntity);
        }
        return reviewsEntity;
    }
}
