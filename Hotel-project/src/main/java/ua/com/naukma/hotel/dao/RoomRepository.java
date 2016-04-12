package ua.com.naukma.hotel.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query("UPDATE Room r SET r.status = :status WHERE r.id = :id")
     void updateByRoomStatus(@Param("id")int id,@Param("status") RoomStatus status);

    @Query("Select r FROM Room r JOIN r.reservations res WHERE r.status = 'OCCUPIED'and res.status='PROCESSED' and  DATEDIFF(res.checkOut,CURDATE()) <=1 ")
    Collection<Room> getRoomsWhichReleasedSoon();

    @Query("Select r FROM Room r  WHERE r.status = 'FREE' ")
    Collection<Room> getFree();
}
