package ua.com.naukma.hotel.domain.model;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @NotNull
    private Date checkIn;

    @Future
    @NotNull
    private Date checkOut;

    @NotNull
    @Min(0)
    private int totalPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;


    public Reservation(User user, Room room) {
        this.user = user;
        this.room = room;
        status = ReservationStatus.PLANNED;
    }

    public Reservation() {
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }


    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
