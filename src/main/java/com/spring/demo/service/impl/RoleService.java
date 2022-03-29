package com.spring.demo.service.impl;

import com.spring.demo.entity.RolesEntity;
import com.spring.demo.repository.IRoleRepository;
import com.spring.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<RolesEntity> getAll() {
        return (List<RolesEntity>) roleRepository.findAll();
    }

    @Override
    public RolesEntity addAndUpdate(RolesEntity entity) {
        return roleRepository.save(entity);
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }
}
