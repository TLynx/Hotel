package ua.com.naukma.hotel.domain.services;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface EntityService<T> {
    public List<T> getAll();
    public void update(T entity);
    public T create( T entity);
    public T get(int id);
}
