package ua.com.naukma.hotel.domain.services;

import ua.com.naukma.hotel.domain.model.Reservation;
import ua.com.naukma.hotel.domain.model.ReservationStatus;

import java.util.Collection;

/**
 * Created by ihor on 05.04.2016.
 */
public interface ReservationService extends EntityService<Reservation>{
     Collection<Reservation> getReservationByStatus(ReservationStatus status);
}
