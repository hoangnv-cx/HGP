package com.spring.demo.service;


import com.spring.demo.entity.RoomEntity;

import java.util.List;

public interface IRoomService {
    RoomEntity getRoomByUser(int id);

    List<RoomEntity> getAllRoomByUser();

    String deleteRoom(String ip);
}
