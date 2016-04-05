package ua.com.naukma.hotel.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.naukma.hotel.dao.ReservationRepository;
import ua.com.naukma.hotel.domain.model.Reservation;
import ua.com.naukma.hotel.domain.model.ReservationStatus;
import ua.com.naukma.hotel.domain.services.ReservationService;

import java.util.Collection;
import java.util.List;

@Service("reservationService")
public class DefaultReservationService implements ReservationService{
    @Autowired
    private ReservationRepository repository;

    @Override
    public List<Reservation> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(Reservation entity) {
        repository.save(entity);
    }

    @Override
    public Reservation create(Reservation entity) {
       return repository.save(entity);
    }

    @Override
    public Reservation get(int id) {
        return repository.findOne(id);
    }

    @Override
    public Collection<Reservation> getReservationByStatus(ReservationStatus status) {
        return repository.getReservationByStatus(status);
    }
}
