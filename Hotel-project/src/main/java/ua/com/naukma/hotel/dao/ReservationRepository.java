package ua.com.naukma.hotel.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.naukma.hotel.domain.model.Reservation;
import ua.com.naukma.hotel.domain.model.ReservationStatus;

import java.util.Collection;
public interface ReservationRepository  extends JpaRepository<Reservation,Integer>{

    Collection<Reservation> getReservationByStatus(ReservationStatus status);
    Reservation findByUserName(String username);
}
