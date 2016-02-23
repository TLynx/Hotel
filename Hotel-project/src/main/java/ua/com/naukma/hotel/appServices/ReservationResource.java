package ua.com.naukma.hotel.appServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.naukma.hotel.domain.model.Reservation;
import ua.com.naukma.hotel.domain.model.ReservationStatus;
import ua.com.naukma.hotel.domain.services.EntityService;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/reservation")
public class ReservationResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationResource.class);

    @Qualifier("reservationService")
    @Autowired
    private EntityService<Reservation> reservationService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    public void createReservation(@Valid @RequestBody Reservation reservation) {
        LOGGER.info("reservetion {}",reservation);
        reservation.setStatus(ReservationStatus.PLANNED);
        reservationService.create(reservation);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.PUT)
    public void updateReservation(@Valid @RequestBody Reservation reservation) {
        reservationService.create(reservation);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Reservation> retrieveReservation() {
        return reservationService.getAll();
    }

}
