package ua.com.naukma.hotel.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.naukma.hotel.domain.model.Greeting;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ihor on 18.02.2016.
 */

@RestController
public class HelloWorldController {

    private static final String HELLO_TEMPLATE = "Hello, %s ";
    private final AtomicInteger incrementer = new AtomicInteger();


    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    public Greeting sayHello(@RequestParam(defaultValue = "world") String name){
        return new Greeting(incrementer.incrementAndGet(),String.format(HELLO_TEMPLATE,name));
    }

}
