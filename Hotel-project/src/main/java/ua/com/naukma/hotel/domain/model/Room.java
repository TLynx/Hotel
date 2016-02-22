package ua.com.naukma.hotel.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private RoomType type;

    @Enumerated(EnumType.STRING)
    @NotNull
    private RoomStatus status;

    @Min(0)
    @NotNull
    private int price;
    @Min(0)
    @NotNull
    private int number;

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations = new ArrayList<>();

    public Room() {
    }


    public Room(RoomType type, RoomStatus status, int price) {
        this.type = type;
        this.status = status;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (price != room.price) return false;
        if (status != room.status) return false;
        if (type != room.type) return false;
        if(number != room.number) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + price;
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type=" + type +
                ", status=" + status +
                ", number=" + number +
                ", price=" + price +
                '}';
    }
}
