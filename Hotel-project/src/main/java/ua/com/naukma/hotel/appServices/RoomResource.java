package ua.com.naukma.hotel.appServices;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.naukma.hotel.domain.model.Room;
import ua.com.naukma.hotel.domain.model.RoomStatus;
import ua.com.naukma.hotel.domain.services.IRoomService;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/api/room")
public class RoomResource {
    //провірити рекуаред на реквест боді
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomResource.class);
    private SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private IRoomService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createRoom(@Valid @RequestBody Room room) {
        LOGGER.info("room to create {}" ,room);
        room.setStatus(RoomStatus.FREE);
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
        return service.get(id);
    }

    // api/room?checkIn=28 & checkOut=29
    //return empty collection if rooms that fulfill specified criteria
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<Room> getRooms(@RequestParam String checkIn,@RequestParam String checkOut) throws ParseException {
        Date checkInDate = formater.parse(checkIn);
        Date checkOutDate = formater.parse(checkOut);
        LOGGER.info("check in {} , check out {}",checkInDate, checkOutDate);
        return service.getAvailableRooms(checkInDate,checkOutDate);
    }

    @RequestMapping(value = "/releasedSoon", method = RequestMethod.GET)
    public Collection<Room> getRoomsWhichReleasedSoon() {
        return service.getRoomsWhichReleasedSoon();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public void updateStatus(@PathVariable Integer id) {
         service.updateByRoomStatus(id, RoomStatus.FREE);
    }
    @RequestMapping(value ="/free",method = RequestMethod.GET)
    public Collection<Room> getFree() {
        return service.getFree();
    }
}
