package com.exam.ekaterine_gurgenidze.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private String roomNumber;

    private Integer price;

    private Long hotel_id;
}
