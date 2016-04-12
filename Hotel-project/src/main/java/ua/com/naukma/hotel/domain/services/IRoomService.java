package ua.com.naukma.hotel.domain.services;

import ua.com.naukma.hotel.domain.model.Room;
import ua.com.naukma.hotel.domain.model.RoomStatus;

import java.util.Collection;
import java.util.Date;


public interface IRoomService extends EntityService<Room> {
      public Collection<Room> getAvailableRooms(Date checkIn,Date checkOut);
      void activateByReservationId(int reservationId);
      Collection<Room> getRoomsWhichReleasedSoon();
      Collection<Room> getFree();
      void updateByRoomStatus(int id, RoomStatus status);
}
