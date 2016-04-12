package ua.com.naukma.hotel.domain.services.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.naukma.hotel.dao.ReservationRepository;
import ua.com.naukma.hotel.domain.model.Reservation;
import ua.com.naukma.hotel.domain.model.RoomStatus;

import java.util.Collection;
import java.util.Date;

@Service
public class EvictionJobServcie {
    private static final Logger LOGGER = LoggerFactory.getLogger(EvictionJobServcie.class);

    @Autowired
    private ReservationRepository repository;

    @Transactional
    @Scheduled(cron = "0 39 13 * * ?")
    public void doEviction(){
       LOGGER.info("-> job is started");

        Date currentDate = new Date();
        Collection<Reservation> reservation = repository.getActiveReservation();
        for (Reservation activeReservation : reservation) {
            System.out.println("activeReservation = " + activeReservation + " is found");

            Date checkOutDate = activeReservation.getCheckOut();
            if(!(checkOutDate.compareTo(currentDate) > 0 )){
                activeReservation.getRoom().setStatus(RoomStatus.FREE);
                System.out.println("evict user from  = " + activeReservation.getRoom() );
            }
        }

        LOGGER.info("-> job has done");
    }
}
