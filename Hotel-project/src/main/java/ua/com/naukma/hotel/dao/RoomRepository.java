package ua.com.naukma.hotel.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.naukma.hotel.domain.model.Room;
import ua.com.naukma.hotel.domain.model.RoomStatus;

import java.util.Collection;
import java.util.Date;


public interface RoomRepository extends JpaRepository<Room,Integer> {

     @Query("Select r FROM Room r where r.id not in (" +
              "  Select res.room.id FROM Reservation res WHERE  res.checkIn between :checkIn AND  :checkOut " +
              "or res.checkOut between :checkIn AND  :checkOut or ( res.checkIn < :checkIn and res.checkOut > :checkOut)  ) ")
     Collection<Room> getAvailableRooms(@Param("checkIn") Date checkIn,@Param("checkOut")Date checkOut);

     @Query("UPDATE Room r SET r.status = :status where r.id = (SELECT res.room.id FROM Reservation res where res.id=:id)")
     void updateByStatus(@Param("id") int reservationId,@Param("status") RoomStatus status);

}
