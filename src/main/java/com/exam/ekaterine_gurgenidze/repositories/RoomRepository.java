package com.exam.ekaterine_gurgenidze.repositories;

import com.exam.ekaterine_gurgenidze.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "select * from room where not exists(" +
            "select * from reservation where reservation.room_id=room.id AND" +
            " CURRENT_TIMESTAMP between reservation.check_in_time AND reservation.check_out_time)",
    nativeQuery = true)
    List<Room> findFreeRooms();

    @Query(value = "select * from room where exists(" +
            "select * from reservation where reservation.room_id=room.id AND" +
            " CURRENT_TIMESTAMP between reservation.check_in_time AND reservation.check_out_time)",
            nativeQuery = true)
    List<Room> findNotFreeRooms();

}
