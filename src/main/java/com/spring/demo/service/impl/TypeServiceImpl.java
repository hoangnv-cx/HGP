package com.spring.demo.service.impl;

import com.spring.demo.entity.TypesEntity;
import com.spring.demo.repository.ITypeRepository;
import com.spring.demo.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements ITypeService {
    @Autowired
    private ITypeRepository typeRepository;
    @Override
    public TypesEntity findById(int id) {
        return typeRepository.findById(id).get();
    }
}
