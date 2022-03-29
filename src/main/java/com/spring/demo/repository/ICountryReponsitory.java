package com.spring.demo.repository;

import com.spring.demo.entity.CountrysEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryReponsitory extends CrudRepository<CountrysEntity, Integer> {

}
