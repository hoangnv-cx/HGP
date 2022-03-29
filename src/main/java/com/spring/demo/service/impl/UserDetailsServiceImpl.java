package com.spring.demo.service.impl;

import com.spring.demo.entity.RolesEntity;
import com.spring.demo.entity.UsersEntity;
import com.spring.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UsersEntity entity = userRepository.findByUserName(userName);
        if (entity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<RolesEntity> roleEntities = entity.getRoles();
        List<String> roleCode = new ArrayList<>();
        for (RolesEntity role : roleEntities) {
            roleCode.add(role.getRoleName());
        }
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleCode != null) {
            for (String role : roleCode) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        UserDetails userDetails = (UserDetails) new User(entity.getUserName(),
                entity.getPassWord(), grantList);
        return userDetails;
    }
}
