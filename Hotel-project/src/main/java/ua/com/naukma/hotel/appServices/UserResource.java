package ua.com.naukma.hotel.appServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.naukma.hotel.domain.model.User;
import ua.com.naukma.hotel.domain.services.UserService;

import java.util.Collection;

@RestController
@RequestMapping("api/user")
public class UserResource {

    @Qualifier("userService")
    @Autowired
    private UserService userService;

    /**
     * return all users
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> retrieveUsers(){
        return userService.getAll();
    }

    /**
     * @return users that are living in a hotel now
     */
    @RequestMapping("/filter/residents")
    public Collection<User> getListOfResidents(){
       return userService.getListOfResidents();
    }

    /**
     * @return  guests which booked rooms in this year
     */
    @RequestMapping("/filter/terminated")
    public Collection<User> getListOfTerminatedResidents(){
        return userService.getBookingHistory();
    }
}
