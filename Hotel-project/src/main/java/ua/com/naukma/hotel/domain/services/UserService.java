package ua.com.naukma.hotel.domain.services;

import ua.com.naukma.hotel.domain.model.User;

import java.util.Collection;


public interface UserService extends EntityService<User> {
    Collection<User> getListOfResidents();
    Collection<User> getBookingHistory();
}
