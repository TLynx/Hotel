package ua.com.naukma.hotel.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.com.naukma.hotel.domain.model.Reservation;
import ua.com.naukma.hotel.domain.model.ReservationStatus;

import java.util.Collection;
public interface ReservationRepository  extends JpaRepository<Reservation,Integer>{

    Collection<Reservation> getReservationByStatus(ReservationStatus status);
    Reservation findByUserName(String username);
    @Query("select r from Reservation r where r.room.status='OCCUPIED' and r.status='PROCESSED'")
    Collection<Reservation> getActiveReservation();

    @Query("select r from Reservation r where r.room.status='FREE' and r.status='PROCESSED'")
    Collection<Reservation> getHistory();
}
