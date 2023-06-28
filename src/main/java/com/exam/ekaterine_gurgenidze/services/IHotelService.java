package com.exam.ekaterine_gurgenidze.services;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.HotelDto;

import java.util.List;

public interface IHotelService {
    ApiResponse add(HotelDto hotelDto);
    ApiResponse delete(Long Id);
    ApiResponse getAll();
    ApiResponse update(HotelDto hotelDto, Long Id);
    ApiResponse getFreeRooms(List<Long> HotelIds);
    ApiResponse getYearlyReport(Long HotelId);
}
