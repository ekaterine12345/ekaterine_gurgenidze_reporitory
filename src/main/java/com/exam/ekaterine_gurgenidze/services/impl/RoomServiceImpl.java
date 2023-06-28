package com.exam.ekaterine_gurgenidze.services.impl;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.RoomDto;
import com.exam.ekaterine_gurgenidze.entities.Room;
import com.exam.ekaterine_gurgenidze.repositories.RoomRepository;
import com.exam.ekaterine_gurgenidze.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements IRoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public ApiResponse add(RoomDto roomDto) {
        if (roomDto.getRoomNumber() == null) {
            return new ApiResponse().addError("roomDto in null", roomDto);
        }

        Room room = new Room(roomDto);
        Room insertedRoom = this.roomRepository.save(room);
        return new ApiResponse("inserted room", insertedRoom);
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("rooms ", this.roomRepository.findAll());
    }

    @Override
    public ApiResponse delete(Long Id) {
        return null;
    }

    @Override
    public ApiResponse update(RoomDto roomDto, Long Id) {
        return null;
    }

    @Override
    public ApiResponse getFreeRooms() {
        return new ApiResponse("free rooms", this.roomRepository.findFreeRooms());
    }

    @Override
    public ApiResponse getNotFreeRooms() {
        return new ApiResponse("not free rooms", this.roomRepository.findNotFreeRooms());
    }
}
