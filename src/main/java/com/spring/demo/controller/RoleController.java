package com.spring.demo.controller;

import com.spring.demo.entity.RolesEntity;
import com.spring.demo.service.IRoleService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Role Api")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping(value = "/role")
    public List<RolesEntity> getAllRole() {
        return roleService.getAll();
    }

    @PostMapping(value = "/role")
    public RolesEntity addRole(@RequestBody RolesEntity entity) {
        entity.setId(null);
        return roleService.addAndUpdate(entity);
    }

    @PutMapping(value = "/role")
    public RolesEntity updateRole(@RequestBody RolesEntity entity) {
        return roleService.addAndUpdate(entity);
    }

    @DeleteMapping(value = "/role/{id}")
    public void deleteRole(@PathVariable("id") @Parameter(example = "1") int id) {
        roleService.deleteRole(id);
    }
}
