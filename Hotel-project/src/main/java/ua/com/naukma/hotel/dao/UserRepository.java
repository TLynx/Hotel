package ua.com.naukma.hotel.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.com.naukma.hotel.domain.model.User;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u JOIN u.reservations res where res.room.status = 'OCCUPIED' ")
    Collection<User> getResidents();

    @Query("SELECT u FROM User u JOIN u.reservations res where res.status = 'PROCESSED'and res.room.status = 'FREE' and YEAR(res.checkOut) >= YEAR(CURDATE())-1 ")
    Collection<User> getBookingHistory();
}
