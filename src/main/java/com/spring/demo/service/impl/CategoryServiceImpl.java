package com.spring.demo.service.impl;

import com.spring.demo.entity.CategoriesEntity;
import com.spring.demo.repository.ICategoryRepository;
import com.spring.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public CategoriesEntity findCateById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
