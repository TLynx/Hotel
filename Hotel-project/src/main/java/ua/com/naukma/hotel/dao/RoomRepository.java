package ua.com.naukma.hotel.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.naukma.hotel.domain.model.Room;

import java.util.Collection;
import java.util.Date;


public interface RoomRepository extends JpaRepository<Room,Integer> {
  @Query("Select r FROM ROOM r where r.id not in (" +
          "  Select res.room.id FROM RESERVATION res WHERE  res.room.checkIn between :checkIn AND  :checkOut " +
          "or res.room.checkOut between :checkIn AND  :checkOut or ( res.room.checkIn < :checkIn and res.room.checkout > :checkOut)  ) ")
  public Collection<Room> getAvailableRooms(@Param("checkIn") Date checkIn,@Param("checkOut")Date checkOut);
}
