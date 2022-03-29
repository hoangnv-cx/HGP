package com.spring.demo.repository;

import com.spring.demo.entity.ReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IReviewRepository extends JpaRepository<ReviewsEntity,Integer> {

}
