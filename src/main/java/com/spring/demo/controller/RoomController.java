package com.spring.demo.controller;

import com.spring.demo.entity.RoomEntity;
import com.spring.demo.service.IRoomService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Room Api")
public class RoomController {
    @Autowired
    IRoomService roomService;

    @GetMapping(value = "/room/{id}")
    public RoomEntity getRoomByUser(@PathVariable("id") @Parameter(example = "14") int id) {
        return roomService.getRoomByUser(id);
    }

    @GetMapping(value = "/room")
    public List<RoomEntity> getAllRoomByUser() {
        return roomService.getAllRoomByUser();
    }

    @DeleteMapping(value = "/room/{ip}")
    public String deleteRoom(@PathVariable("ip") @Parameter(example = "20210413105916704") String ip) {
        return roomService.deleteRoom(ip);
    }
}
