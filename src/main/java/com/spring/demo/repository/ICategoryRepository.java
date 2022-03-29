package com.spring.demo.repository;

import com.spring.demo.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoriesEntity, Integer> {

}
