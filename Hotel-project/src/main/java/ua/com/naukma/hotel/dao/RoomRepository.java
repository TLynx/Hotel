package ua.com.naukma.hotel.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.naukma.hotel.domain.model.Room;


public interface RoomRepository extends JpaRepository<Room,Integer> {

}
