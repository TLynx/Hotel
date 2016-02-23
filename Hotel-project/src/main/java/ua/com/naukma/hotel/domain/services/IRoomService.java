package ua.com.naukma.hotel.domain.services;

import ua.com.naukma.hotel.domain.model.Room;

import java.util.Collection;
import java.util.Date;


public interface IRoomService extends EntityService<Room> {
      public Collection<Room> getAvailableRooms(Date checkIn,Date checkOut);
}
