package ua.com.naukma.hotel.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.naukma.hotel.domain.model.Reservation;

public interface ReservationRepository  extends JpaRepository<Reservation,Integer>{
}
