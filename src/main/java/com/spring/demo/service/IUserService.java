package com.spring.demo.service;

import com.spring.demo.entity.UsersEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IUserService {
    UsersEntity addAndUpdate(UsersEntity entity);

    UsersEntity getByUser();

    List<UsersEntity> getUserAll();

    void deleteUser(int id);

    void addPhone(String phone);

    boolean updateImage(MultipartFile file);

}
