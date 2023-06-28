package com.exam.ekaterine_gurgenidze.services;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.RoomDto;

public interface IRoomService {
    ApiResponse add(RoomDto roomDto);
    ApiResponse getAll();
    ApiResponse delete(Long Id);
    ApiResponse update(RoomDto roomDto, Long Id);
    ApiResponse getFreeRooms();
    ApiResponse getNotFreeRooms();
}
