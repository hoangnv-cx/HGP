package com.spring.demo.service.impl;

import com.spring.demo.entity.CountrysEntity;
import com.spring.demo.repository.ICountryReponsitory;
import com.spring.demo.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements ICountryService {
    @Autowired
    private ICountryReponsitory countryReponsitory;
    @Override
    public CountrysEntity findById(int id) {
        return countryReponsitory.findById(id).orElse(null);
    }

}
