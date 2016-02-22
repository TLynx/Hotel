package ua.com.naukma.hotel.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.naukma.hotel.dao.RoomRepository;
import ua.com.naukma.hotel.domain.model.Room;
import ua.com.naukma.hotel.domain.services.EntityService;

import java.util.List;

@Service()
public class RoomService implements EntityService<Room> {

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

}
