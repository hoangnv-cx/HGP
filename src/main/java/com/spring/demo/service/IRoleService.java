package com.spring.demo.service;

import com.spring.demo.entity.RolesEntity;

import java.util.List;

public interface IRoleService {
    List<RolesEntity> getAll();

    RolesEntity addAndUpdate(RolesEntity entity);

    void deleteRole(int id);

}
