package ua.com.naukma.hotel.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.naukma.hotel.domain.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
