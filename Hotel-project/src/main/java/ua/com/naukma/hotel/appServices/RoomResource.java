package ua.com.naukma.hotel.appServices;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.naukma.hotel.domain.model.Room;
import ua.com.naukma.hotel.domain.model.RoomStatus;
import ua.com.naukma.hotel.domain.model.RoomType;
import ua.com.naukma.hotel.domain.services.EntityService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomResource.class);

    @Qualifier("roomService")
    @Autowired()
    private EntityService<Room> service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createRoom(@Valid @RequestBody Room room) {
        LOGGER.info("room to create {}" ,room);
        return ResponseEntity.ok(service.create(room));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateRoom(@Valid @RequestBody Room room) {
        LOGGER.info(" room to update{}" ,room);
        service.update(room);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Room> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Room get(@PathVariable int id) {
        return new Room(RoomType.DOUBLE_DELUXE, RoomStatus.FREE,4234);
    }

}
