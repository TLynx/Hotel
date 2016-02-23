package ua.com.naukma.hotel.appServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.naukma.hotel.domain.model.User;
import ua.com.naukma.hotel.domain.services.EntityService;

import java.util.Collection;

@RestController
@RequestMapping("api/user")
public class UserResource {

    @Qualifier("userService")
    @Autowired
    private EntityService<User> userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> retriveUsers(){
        return userService.getAll();
    }

}
