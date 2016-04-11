package ua.com.naukma.hotel.appServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.naukma.hotel.domain.model.Reservation;
import ua.com.naukma.hotel.domain.model.ReservationStatus;
import ua.com.naukma.hotel.domain.model.Room;
import ua.com.naukma.hotel.domain.model.RoomStatus;
import ua.com.naukma.hotel.domain.services.IRoomService;
import ua.com.naukma.hotel.domain.services.ReservationService;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/reservation")
public class ReservationResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationResource.class);

    @Qualifier("reservationService")
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private IRoomService roomService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/users/{name}",method = RequestMethod.POST)
    public Reservation findByUserName(@PathVariable String name) {
        return reservationService.findByUserName(name) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    public void createReservation(@Valid @RequestBody Reservation reservation) {
        LOGGER.info("reservetion {}", reservation);
        reservation.setStatus(ReservationStatus.PLANNED);
        reservationService.create(reservation);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Reservation> retrievePlannedReservation() {
        return reservationService.getReservationByStatus(ReservationStatus.PLANNED);
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public Collection<Reservation> getAll() {
        return reservationService.getAll();
    }
    /**
     * set Room status to OCCUPIED
     * set Reservation status to PROCESSED
     * @param reservation
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.PUT)
    public void process(@Valid @RequestBody Reservation reservation) {
        reservation.setStatus(ReservationStatus.PROCESSED);
        LOGGER.debug("PUT /api/reservation {}", reservation.getStatus());
        Room room = reservation.getRoom();
        room.setStatus(RoomStatus.OCCUPIED);
        roomService.update(room);
        reservationService.update(reservation);
    }

    @RequestMapping(value = "/active",method = RequestMethod.GET)
    public Collection<Reservation> getActiveReservations(){
        return reservationService.getActiveReservation();
    }

    @RequestMapping(value = "/history",method = RequestMethod.GET)
    public Collection<Reservation> getHistory(){
        return reservationService.getHistory();
    }
}
