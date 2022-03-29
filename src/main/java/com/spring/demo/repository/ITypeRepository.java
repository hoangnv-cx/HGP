package com.spring.demo.repository;

import com.spring.demo.entity.TypesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends CrudRepository<TypesEntity, Integer> {
}
