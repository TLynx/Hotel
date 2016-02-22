package ua.com.naukma.hotel.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.naukma.hotel.dao.UserRepository;
import ua.com.naukma.hotel.domain.model.User;
import ua.com.naukma.hotel.domain.services.EntityService;

import java.util.List;

@Service
public class UserService implements EntityService<User> {

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
}
