package com.spring.demo.service.impl;

import com.spring.demo.entity.RolesEntity;
import com.spring.demo.entity.UsersEntity;
import com.spring.demo.repository.IRoleRepository;
import com.spring.demo.repository.IUserRepository;
import com.spring.demo.service.IUserService;
import com.spring.demo.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${app.upload.dir}")
    private String UPLOAD_DIR;
    @Override
    public UsersEntity addAndUpdate(UsersEntity entity) {
        List<RolesEntity> roles = new ArrayList<>();
        for (RolesEntity roleEntity : entity.getRoles()) {
            RolesEntity role = roleRepository.findByRoleName(roleEntity.getRoleName());
            roles.add(role);
        }
        entity.setPassWord(passwordEncoder.encode(entity.getPassWord()));
        entity.setRoles(roles);
        return userRepository.save(entity);
    }

    @Override
    public UsersEntity getByUser() {
        return userRepository.findByUserName(SecurityUtils.getName());
    }

    @Override
    public List<UsersEntity> getUserAll() {
        return (List<UsersEntity>) userRepository.findAll();
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addPhone(String phone) {
        userRepository.updatePhone(phone, SecurityUtils.getName());
    }

    @Override
    public boolean updateImage(MultipartFile file) {
        boolean check=false;
        Path path = Paths.get(UPLOAD_DIR);
        try {
            Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            userRepository.updateImage(file.getOriginalFilename(),SecurityUtils.getName());
            check=true;
        }catch (Exception e){
        }
        return check;
    }
}
