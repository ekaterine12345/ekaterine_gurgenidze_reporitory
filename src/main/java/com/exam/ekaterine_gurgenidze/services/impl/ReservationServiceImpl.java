package com.exam.ekaterine_gurgenidze.services.impl;

import com.exam.ekaterine_gurgenidze.dtos.ApiResponse;
import com.exam.ekaterine_gurgenidze.dtos.ReservationDto;
import com.exam.ekaterine_gurgenidze.entities.Reservation;
import com.exam.ekaterine_gurgenidze.repositories.ReservationRepository;
import com.exam.ekaterine_gurgenidze.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ApiResponse add(ReservationDto reservationDto) {
        if (reservationDto.getRoom_id() == null){
            return new ApiResponse().addError("reservationDto in null", reservationDto);
        }

        Reservation reservation = new Reservation(reservationDto);
        Reservation insertedReservation = this.reservationRepository.save(reservation);
        return new ApiResponse("insertedReservation", insertedReservation);
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("reservations", this.reservationRepository.findAll());
    }

    @Override
    public ApiResponse delete(Long Id) {
        return null;
    }

    @Override
    public ApiResponse update(ReservationDto reservationDto, Long Id) {
        return null;
    }
}
