package com.exam.ekaterine_gurgenidze.controllers;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.RoomDto;
import com.exam.ekaterine_gurgenidze.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final IRoomService roomService;

    @Autowired
    public RoomController(IRoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ApiResponse getAllRooms(){
        return this.roomService.getAll();
    }

    @PostMapping("/add")
    public ApiResponse addRoom(@RequestBody RoomDto roomDto){
        System.out.println("Room Dto = " + roomDto);
        return this.roomService.add(roomDto);
    }

    @GetMapping("/free")
    public ApiResponse getFreeRooms(){
        return this.roomService.getFreeRooms();
    }

    @GetMapping("/not_free")
    public ApiResponse getNotFreeRooms(){
        return this.roomService.getNotFreeRooms();
    }
}
