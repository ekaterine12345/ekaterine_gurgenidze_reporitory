package com.exam.ekaterine_gurgenidze.repositories;

import com.exam.ekaterine_gurgenidze.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface HotelRepository extends JpaRepository<Hotel, Long> {


    @Query(value = "select * from room where room.hotel_id= :hotelId AND NOT EXISTS(" +
            "select * from reservation where CURRENT_TIMESTAMP between reservation.check_in_time AND" +
            " reservation.check_out_time)",
            nativeQuery = true)
    List<Map<String, Object>> getFreeRoomsByHotelId(@Param("hotelId") Long hotelId);


    @Query(value = "select hotel.name, COUNT(room.id), " +
            " SUM(room.price * DATEDIFF(reservation.check_out_time, reservation.check_in_time)) as Money " +
            " from hotel" +
            " JOIN room on room.hotel_id=hotel.id" +
            " JOIN reservation on reservation.room_id=room.id " +
            " where hotel.id= :hotelId" +
            " GROUP BY YEAR(reservation.check_in_time)", nativeQuery = true)
    List<Object[]> hotelReport(@Param("hotelId") Long hotelId);

//    @Query(value = "SELECT hotel.name AS HotelName, YEAR(reservation.check_in_time) AS rentalYear," +
//            " COUNT(room.id) AS RentRoom," +
//            " COUNT(DISTINCT room.id) AS NumberofRooms," +
//            " SUM(room.price * DATEDIFF(reservation.check_out_time, reservation.check_in_time)) AS Money," +
//            " SUM(DATEDIFF(reservation.check_out_time, reservation.check_in_time)) AS duration " +
//            "FROM reservation " +
//            "JOIN room ON reservation.room_id = room.id " +
//            "JOIN hotel ON room.hotel_id = hotel.id " +
//            "WHERE hotel.id = :hotelId " +
//            "GROUP BY rentalYear",
//            nativeQuery = true)
//    List<Object> getYearlyReport(@Param("hotelId") Long hotelId);



    // Booking 2
    /*

        //    @Query(value = "select * from room r where room.hotel_id = :hotelID AND "+
//            " NOT EXSISTS (select * from reservation res where res.room_id = r.id" +
//            "AND CURRENT_TIMESTAMP() BETWEEN res.check_in_time and res.check_out_time)", nativeQuery = true)
//    List<Room> getFreeRoomsByHotelId(@Param("hotelId") Long hotelID);

    @Query(value = "SELECT * FROM room r " +
            "WHERE r.hotel_id = :hotelId AND NOT EXISTS (" +
            "  SELECT 1 FROM reservation res " +
            "  WHERE res.room_id = r.id " +
            "  AND (CURRENT_TIMESTAMP() BETWEEN res.check_in_time AND res.check_out_time)" +
            ")",
            nativeQuery = true)
    List<Map<String, Object>> getFreeRoomsByHotelId(@Param("hotelId") Long hotelId);



//    @Query("SELECT r FROM Room r WHERE r.hotel.id = :hotelId AND NOT EXISTS " +
//            "(SELECT res FROM Reservation res WHERE res.room.Id = r.Id AND " +
//            "CURRENT_TIMESTAMP() BETWEEN res.checkInTime AND res.checkOutTime)")
//    List<Room> getFreeRoomsByHotelId(@Param("hotelId") Long hotelId);



    @Query(value = "SELECT hotel.name AS HotelName, YEAR(reservation.check_in_time) AS rentalYear," +
            " COUNT(room.id) AS RentRoom," +
            " COUNT(DISTINCT room.id) AS NumberofRooms," +
            " SUM(room.price * DATEDIFF(reservation.check_out_time, reservation.check_in_time)) AS Money," +
            " SUM(DATEDIFF(reservation.check_out_time, reservation.check_in_time)) AS duration " +
            "FROM reservation " +
            "JOIN room ON reservation.room_id = room.id " +
            "JOIN hotel ON room.hotel_id = hotel.id " +
            "WHERE hotel.id = :hotelId " +
            "GROUP BY rentalYear",
            nativeQuery = true)
    List<Object> getYearlyReport(@Param("hotelId") Long hotelId);





//    @Query("SELECT hotel.name as HotelName, YEAR(reservation.checkInTime) AS rentalYear," +
//            " COUNT(room) AS RentRoom," +
//            " COUNT(distinct room) as NumberofRooms," +
//            " SUM(room.price * DATEDIFF(reservation.checkOutTime, reservation.checkInTime)) AS Money," +
//            "  SUM (DATEDIFF(reservation.checkOutTime, reservation.checkInTime)) AS duration " +
//            "FROM Reservation reservation " +
//            "JOIN reservation.room room " +
//            "JOIN room.hotel hotel " +
//            "WHERE hotel.id = :hotelId " +
//            "GROUP BY rentalYear")
//    List<Object> getYearlyReport(@Param("hotelId") Long hotelId);


//    @Query(value = "select h.name, COUNT(r.hotel_id) as RoomCount" +
//            "  from hotel h" +
//            " JOIN room r on h.id=r.hotel_id " +
//            "GROUP BY h.name " +
//            " ORDER BY RoomCount ",
//            nativeQuery = true)
//    List<Object[]> myQuery1();

    @Query(value = "select hotel.name, count(room.hotel_id), AVG(review.rating) as ratAVG from hotel" +
            " JOIN review on hotel.id=review.hotel_id " +
            " JOIN room on hotel.id=room.hotel_id" +
            " GROUP BY hotel.name" +
            " ORDER BY ratAVG",
            nativeQuery = true)
    List<Object[]> myQuery();


    @Query(value = "select hotel.name, count(room.hotel_id)," +
            " sum(room.price * DATEDIFF(reservation.check_out_time, reservation.check_in_time) ) from hotel " +
            " JOIN room on hotel.id=room.hotel_id" +
            " LEFT JOIN reservation on room.id=reservation.room_id" +
            " where CURRENT_TIMESTAMP() BETWEEN  reservation.check_in_time and reservation.check_out_time" +
            " GROUP BY hotel.name",
    nativeQuery = true)
    List<Object[]> myQuery2();


    //Task: Retrieve a list of hotels along with the count of rooms and the number
    // of active reservations for each hotel.
    @Query(value = "select hotel.name, count(room.hotel_id)," +
            " count(reservation.room_id) from hotel " +
            " JOIN room on hotel.id=room.hotel_id" +
            " LEFT JOIN reservation on room.id=reservation.room_id" +
            " where CURRENT_TIMESTAMP() BETWEEN  reservation.check_in_time and reservation.check_out_time" +
            " GROUP BY hotel.name",
            nativeQuery = true)
    List<Object[]> myQuery1();

     */


}
