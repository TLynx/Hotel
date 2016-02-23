package ua.com.naukma.hotel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import ua.com.naukma.hotel.dao.RoomRepository;
import ua.com.naukma.hotel.domain.model.Room;
import ua.com.naukma.hotel.domain.model.RoomStatus;
import ua.com.naukma.hotel.domain.model.RoomType;

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
    public CommandLineRunner demo( final RoomRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                Room room = new Room(RoomType.QUAD_DELUXE, RoomStatus.FREE,1509,111);
                repository.save(room);
            }
        }   ;
    }

}
