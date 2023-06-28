package com.exam.ekaterine_gurgenidze.entities;

import com.exam.ekaterine_gurgenidze.dtos.ReservationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RESERVATION")
public class Reservation extends AppEntity<Long>{
    @Id
    @Column(name = "Id")
    @SequenceGenerator(name="reservationIdSeq", sequenceName = "RESERVATION_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationIdSeq")
    private Long id;

    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @Column(name = "guest_name")
    private String guestName;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Reservation(ReservationDto reservationDto) {
        this.checkInTime = reservationDto.getCheckInTime();
        this.checkOutTime = reservationDto.getCheckOutTime();
        this.guestName = reservationDto.getGuestName();
        this.room = new Room();
        this.room.setId(reservationDto.getRoom_id());
        this.recordState = RecordState.ACTIVE;
    }
}
