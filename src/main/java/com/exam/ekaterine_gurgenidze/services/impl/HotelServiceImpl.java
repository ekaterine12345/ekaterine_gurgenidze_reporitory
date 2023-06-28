package com.exam.ekaterine_gurgenidze.services.impl;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.HotelDto;
import com.exam.ekaterine_gurgenidze.entities.Hotel;
import com.exam.ekaterine_gurgenidze.repositories.HotelRepository;
import com.exam.ekaterine_gurgenidze.services.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelServiceImpl implements IHotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    @Override
    public ApiResponse add(HotelDto hotelDto) {
        if (hotelDto.getName() == null){
            return new ApiResponse().addError("hotel is null", hotelDto);
        }

        Hotel hotel = new Hotel(hotelDto);
        Hotel insertedHotel = this.hotelRepository.save(hotel);
        return new ApiResponse("inserted hotel", insertedHotel);
    }

    @Override
    public ApiResponse delete(Long Id) {
        return null;
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("get all", this.hotelRepository.findAll());
    }

    @Override
    public ApiResponse update(HotelDto hotelDto, Long Id) {
        return null;
    }

    @Override
    public ApiResponse getFreeRooms(List<Long> HotelIds) {
        Map<String, Object> freeRooms = new HashMap<>();

        for (int i=0; i<HotelIds.size(); i++){
            freeRooms.put("hotel id = " + HotelIds.get(i),
                    this.hotelRepository.getFreeRoomsByHotelId(HotelIds.get(i)));
        }
        return new ApiResponse("free rooms ", freeRooms);
    }

    @Override
    public ApiResponse getYearlyReport(Long HotelId) {
        return new ApiResponse("hotel report", this.hotelRepository.hotelReport(HotelId));
    }
}
