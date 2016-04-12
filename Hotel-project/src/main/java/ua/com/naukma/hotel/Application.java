package ua.com.naukma.hotel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import ua.com.naukma.hotel.dao.ReservationRepository;
import ua.com.naukma.hotel.dao.RoomRepository;
import ua.com.naukma.hotel.domain.model.*;
import static ua.com.naukma.hotel.domain.model.RoomType.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

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
 @EnableScheduling
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
                Room room4 = new Room(TRIPLE_MODERATE, RoomStatus.FREE,1509,3);
                repository.save(room4);
                Room room17 = new Room(DOUBLE_DELUXE, RoomStatus.FREE,900,4);
                repository.save(room17);
            }
        }   ;
    }
    @Bean
    public CommandLineRunner createPlannedReservations( final ReservationRepository repository, final RoomRepository rRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                System.out.println("---     init db      ----");
                Calendar instance = Calendar.getInstance();
                instance.setTime(new Date());
                Room room = new Room(SINGLE_STANDARD, RoomStatus.FREE,200,5);
                Room room2 = new Room(DOUBLE_MODERATE, RoomStatus.FREE,700,6);
                Room room7 = new Room(DOUBLE_STANDARD, RoomStatus.FREE,450,7);
                User user = new User("Petro","Levkovich",5588899);
                User user2 = new User("Oleg","Xoma",53388009);
                User user7 = new User("Olena","Gilka",9922934);
                User [] users  = {user,user2,user7};
                Room [] rooms  = {room,room2,room7};
                instance.add(Calendar.DATE, instance.get(Calendar.DATE) + 1);
                Date date1 = instance.getTime();
                instance.add(Calendar.DATE, instance.get(Calendar.DATE) + 1);
                Date date2 = instance.getTime();
                instance.add(Calendar.DATE, instance.get(Calendar.DATE) + 3);
                Date date3 = instance.getTime();
                Date [] fromDate = {date1,date2,date3};
                Random random = new Random();
                Calendar instance1 = Calendar.getInstance();
                for (int i = 0; i < users.length; i++) {

                    User user1 = users[i];
                    Room room1 = rooms[i];
                    Date date = fromDate[i];
                    instance1.setTime(date);
                    int days = random.nextInt(4) + 1;
                    System.out.println("days = " + days);
                    instance1.add(Calendar.DATE,days);
                    Date till =instance1.getTime();
                    System.out.println("till = " + till);
                    createPlannedReservation(rRepository,repository,till,date,room1,user1,room1.getPrice()*days);
                }
            }
        }   ;
    }

    private void createPlannedReservation(RoomRepository rRepository, ReservationRepository repository,Date till,Date from, Room room,User user,int price) {
        rRepository.save(room);
        Reservation reservation = new Reservation();
        reservation.setRoom(room);
        reservation.setUser(user);
        reservation.setCheckIn(from);
        reservation.setStatus(ReservationStatus.PLANNED);
        reservation.setCheckOut(till);
        reservation.setTotalPrice(price);
        repository.save(reservation) ;
    }


    @Bean
    public CommandLineRunner createActiveReservation( final ReservationRepository repository, final RoomRepository rRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                System.out.println("---     init active reservations      ----");
                Room room3 = new Room(SINGLE_DELUXE, RoomStatus.OCCUPIED,450,8);
                rRepository.save(room3);
                Room room17 = new Room(SINGLE_MODERATE, RoomStatus.OCCUPIED,325,9);
                rRepository.save(room17);
                Room room1 = new Room(SINGLE_MODERATE, RoomStatus.OCCUPIED,325,10);
                rRepository.save(room1);


                User user3 = new User("Ira","Bug",96563723);
                User user17 = new User("Victor","Matkovsliy",433959000);
                User user1 = new User("Vadum","Sedakov",1254421);

                Calendar instance = Calendar.getInstance();
                Date date = new Date();

                instance.setTime(date);
                int days1 = instance.get(Calendar.DATE) + 4;
                instance.add(Calendar.DATE,days1);
                Date till1 = instance.getTime();

                int days2 = instance.get(Calendar.DATE) + 1;
                instance.add(Calendar.DATE,days2);
                Date till2 = instance.getTime();

                int days3 = instance.get(Calendar.DATE) + 2;
                instance.add(Calendar.DATE,days2);
                Date till3 = instance.getTime();

                createActive(room3, user3, repository,till1,date,room3.getPrice()*days1 );
                createActive(room17, user17, repository,till2,date,room17.getPrice()*days2 );
                createActive(room1, user1, repository,till3,date,room1.getPrice()*days3 );
            }
        }   ;
    }

    private void createActive(Room room, User user, ReservationRepository repository,Date till, Date from,int price) {
        Reservation reservation = new Reservation();
        reservation.setRoom(room);
        reservation.setUser(user);
        reservation.setCheckIn(from);
        reservation.setStatus(ReservationStatus.PROCESSED);
        reservation.setCheckOut(till);
        reservation.setTotalPrice(price);
        repository.save(reservation) ;
    }

}
