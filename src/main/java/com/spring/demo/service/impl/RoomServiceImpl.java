package com.spring.demo.service.impl;

import com.spring.demo.entity.RoomEntity;
import com.spring.demo.entity.UsersEntity;
import com.spring.demo.repository.IRoomRepository;
import com.spring.demo.repository.IUserRepository;
import com.spring.demo.service.IRoomService;
import com.spring.demo.service.IUserService;
import com.spring.demo.utils.DateUtil;
import com.spring.demo.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    IRoomRepository roomRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IUserService userService;

    @Override
    public RoomEntity getRoomByUser(int id) {
        UsersEntity userSend = userService.getByUser();
        UsersEntity userReceive = userRepository.findById(id).orElse(null);
        RoomEntity roomEntity = roomRepository.getRoomByUser(userSend.getId(), userReceive.getId());
        if (roomEntity == null) {
            RoomEntity entity = new RoomEntity();
            int min = 100;
            int max = 999;
            int random_int;
            boolean check = true;
            do {
                random_int = (int) (Math.random() * (max - min + 1) + min);
                Date data = new Date();
                String dates = DateUtil.getDate(data);
                String ip=dates+String.valueOf(random_int);
                RoomEntity room = roomRepository.findByIp(ip);
                if (room == null) {
                    entity.setIp(ip);
                    check = false;
                }


        } while (check) ;
        entity.setUserSend(userSend);
        entity.setUserTake(userReceive);
        entity.setStatus((byte) 1);
        entity.setMessId(0);
        roomRepository.save(entity);
        return entity;
    }
        return roomEntity;
}

    @Override
    public List<RoomEntity> getAllRoomByUser() {
        UsersEntity usersEntity = userService.getByUser();
        List<RoomEntity> roomEntities = roomRepository.getAllRoomByUser(usersEntity.getId());
        return roomEntities;
    }

    @Override
    public String deleteRoom(String ip) {
        UsersEntity usersEntity = userService.getByUser();
        RoomEntity roomEntity = roomRepository.getRoom(usersEntity.getId(), ip);
        if (roomEntity != null) {
            roomRepository.deleteRoomUser(ip);
            return "success";
        }
        return "fail";
    }
}
