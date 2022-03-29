package com.spring.demo.repository;


import com.spring.demo.entity.RolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends CrudRepository<RolesEntity, Integer> {
    RolesEntity findByRoleName(String roleName);
}
