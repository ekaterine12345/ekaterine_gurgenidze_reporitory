package com.exam.ekaterine_gurgenidze.entities;

import com.exam.ekaterine_gurgenidze.dtos.RoomDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ROOM")
public class Room extends AppEntity<Long>{
    @Id
    @Column(name = "Id")
    @SequenceGenerator(name="roomIdSeq", sequenceName = "ROOM_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomIdSeq")
    private Long id;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Room(RoomDto roomDto) {
        this.roomNumber = roomDto.getRoomNumber();
        this.price = roomDto.getPrice();
        this.hotel = new Hotel();
        this.hotel.setId(roomDto.getHotel_id());
        this.recordState = RecordState.ACTIVE;
    }
}
