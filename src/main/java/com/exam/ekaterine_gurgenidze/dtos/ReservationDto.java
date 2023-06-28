package com.exam.ekaterine_gurgenidze.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

    private String guestName;

    private Long room_id;
}
