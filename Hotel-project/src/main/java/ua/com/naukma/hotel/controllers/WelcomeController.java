package ua.com.naukma.hotel.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Map;

@Controller
public class WelcomeController {

    @Value("application.message")
    private String message;

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String getWelcome(Map<String, Object> model){
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

}
