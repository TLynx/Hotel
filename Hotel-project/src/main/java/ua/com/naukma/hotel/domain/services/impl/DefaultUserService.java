package ua.com.naukma.hotel.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.naukma.hotel.dao.UserRepository;
import ua.com.naukma.hotel.domain.model.User;
import ua.com.naukma.hotel.domain.services.UserService;

import java.util.Collection;
import java.util.List;
@Transactional
@Service("userService")
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(User entity) {
        repository.save(entity);
    }

    @Override
    public User create(User entity) {
        return repository.save(entity);
    }

    @Override
    public User get(int id) {
        return repository.getOne(id);
    }

    @Override
    public Collection<User> getListOfResidents(){
        return repository.getResidents();
    }

    @Override
    public Collection<User> getBookingHistory() {
        return repository.getBookingHistory();
    }
}
