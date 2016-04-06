package ua.com.naukma.hotel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import ua.com.naukma.hotel.dao.ReservationRepository;
import ua.com.naukma.hotel.dao.RoomRepository;
import ua.com.naukma.hotel.domain.model.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
@Configuration tags the class as a source of bean definitions for the application context.
@EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings,
other beans, and various property settings.
Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it
automatically when it sees spring-webmvc on the classpath.
This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
 scan for entity classes and extend classes  from the Repository or CrudRepository interfaces
@ComponentScan tells Spring to look for other components, configurations, and appServices in the hello package,
allowing it to find the GreetingController

 * Created by ihor on 18.02.2016.
 */
 @SpringBootApplication
 @ImportResource("classpath*:connnection.xml")
public class Application {

    public static void main(String [] args){
        System.setProperty("user.language","en") ;
        System.setProperty("user.region","EN");

        System.setProperty("user.country","EN");
        Locale.setDefault(Locale.ENGLISH);
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(final RoomRepository repository ) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                Room room = new Room(RoomType.DOUBLE_MODERATE, RoomStatus.FREE,700,7);
                repository.save(room);
                Room room7 = new Room(RoomType.DOUBLE_STANDARD, RoomStatus.FREE,450,3);
                repository.save(room7);
                Room room2 = new Room(RoomType.SINGLE_STANDARD, RoomStatus.FREE,250,2);
                repository.save(room2);
                Room room3 = new Room(RoomType.SINGLE_DELUXE, RoomStatus.FREE,450,10);
                repository.save(room3);
                Room room4 = new Room(RoomType.TRIPLE_MODERATE, RoomStatus.FREE,1509,4);
                repository.save(room4);
                Room room17 = new Room(RoomType.DOUBLE_DELUXE, RoomStatus.FREE,900,17);
                repository.save(room17);
            }
        }   ;
    }
    @Bean
    public CommandLineRunner createReservation( final ReservationRepository repository, final RoomRepository rRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                System.out.println("---     init db      ----");
                Room room = new Room(RoomType.QUAD_DELUXE, RoomStatus.FREE,1509,111);
                rRepository.save(room);
                User user = new User("Test","Test",12345);
                Reservation reservation = new Reservation();
                reservation.setRoom(room);
                reservation.setUser(user);
                Calendar instance = Calendar.getInstance();
                instance.setTime(new Date());
               // instance.add(Calendar.DATE, 5);
                reservation.setCheckIn(instance.getTime());
                reservation.setStatus(ReservationStatus.PROCESSED);
                //instance.add(Calendar.DATE, 7);
                reservation.setCheckOut(instance.getTime());
                reservation.setTotalPrice(735);
                repository.save(reservation) ;

            }
        }   ;
    }
}
