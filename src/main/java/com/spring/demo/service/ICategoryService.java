package com.spring.demo.service;

import com.spring.demo.entity.CategoriesEntity;

public interface ICategoryService {
    CategoriesEntity findCateById(int id);
}
