package com.spring.demo.controller;

import com.spring.demo.entity.UsersEntity;
import com.spring.demo.service.IUserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "User Api")
public class UserController {


    @Autowired
    private IUserService userService;

    @GetMapping(value = "/user/profile")
    public UsersEntity getByUser() {
        return userService.getByUser();
    }

    @GetMapping(value = "/user")
    public List<UsersEntity> getUserAll() {
        return userService.getUserAll();
    }

    @PostMapping(value = "/user")
    public UsersEntity addUser(@RequestBody UsersEntity entity) {
        entity.setId(null);
        return userService.addAndUpdate(entity);
    }

    @PutMapping(value = "/user")
    public UsersEntity updateUser(@RequestBody UsersEntity entity) {
        return userService.addAndUpdate(entity);
    }


    @DeleteMapping(value = "/user")
    public void deleteUser(@RequestParam("id") @Parameter(example = "4") Integer id) {
        userService.deleteUser(id);
    }

    @PostMapping(value = "/phone")
    public void updatePhone(@RequestParam("phone") @Parameter(example = "1234567890") String phone) {
        userService.addPhone(phone);
    }

    @PostMapping(value = "/user/image" , consumes = {"multipart/form-data"})
    public ResponseEntity<String> updateImage(@ModelAttribute MultipartFile file){
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("null");
        }
        if(!file.getContentType().equals("image/jpeg")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not image/jpeg");
        }
        try {
            if(userService.updateImage(file)){

                return ResponseEntity.ok("success");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
    }

}
