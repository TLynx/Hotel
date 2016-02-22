package ua.com.naukma.hotel.domain.services.impl;

import org.springframework.stereotype.Service;
import ua.com.naukma.hotel.dao.ReservationRepository;
import ua.com.naukma.hotel.domain.model.Reservation;
import ua.com.naukma.hotel.domain.services.EntityService;

import java.util.List;

@Service
public class ReservationService implements EntityService<Reservation> {

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
}
