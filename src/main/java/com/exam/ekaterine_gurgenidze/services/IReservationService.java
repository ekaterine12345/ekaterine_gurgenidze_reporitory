package com.exam.ekaterine_gurgenidze.services;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.ReservationDto;
import com.exam.ekaterine_gurgenidze.dtos.RoomDto;

public interface IReservationService {
    ApiResponse add(ReservationDto reservationDto);
    ApiResponse getAll();
    ApiResponse delete(Long Id);
    ApiResponse update(ReservationDto reservationDto, Long Id);
}
