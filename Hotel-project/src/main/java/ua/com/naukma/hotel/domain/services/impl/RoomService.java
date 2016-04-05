package ua.com.naukma.hotel.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.naukma.hotel.dao.RoomRepository;
import ua.com.naukma.hotel.domain.model.Room;
import ua.com.naukma.hotel.domain.model.RoomStatus;
import ua.com.naukma.hotel.domain.services.IRoomService;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service()
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepository repository;

    @Override
    public List<Room> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(Room room) {
        repository.save(room);
    }

    @Override
    public Room create(Room room) {
        return repository.save(room);
    }

    @Override
    public Room get(int id) {
        return repository.findOne(id);
    }

    @Override
    public Collection<Room> getAvailableRooms(Date checkIn, Date checkOut) {
        return repository.getAvailableRooms(checkIn,checkOut);
    }

    @Override
    public void activateByReservationId(int reservationId) {
       repository.updateByStatus(reservationId, RoomStatus.OCCUPIED);
    }

    @Override
    public void releaseByReservationId(int reservationId) {
        repository.updateByStatus(reservationId, RoomStatus.FREE);
    }

}
