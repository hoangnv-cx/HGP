package com.spring.demo.repository;


import com.spring.demo.entity.UsersEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IUserRepository extends CrudRepository<UsersEntity, Integer> {
    UsersEntity findByUserName(String userName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET phone = :phone WHERE user_name = :user_name", nativeQuery = true)
    void updatePhone(@Param("phone") String phone, @Param("user_name") String userName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET image = :image WHERE user_name = :user_name", nativeQuery = true)
    void updateImage(@Param("image") String image, @Param("user_name") String userName);
}
