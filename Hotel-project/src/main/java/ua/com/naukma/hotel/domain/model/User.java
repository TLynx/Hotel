package ua.com.naukma.hotel.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ihor on 21.02.2016.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String secondName;

    private int cellphone;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations = new ArrayList<>();

    public User() {
    }

    public User(String name, String secondName, int cellphone) {
        this.name = name;
        this.secondName = secondName;
        this.cellphone = cellphone;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (cellphone != user.cellphone) return false;
        if (!name.equals(user.name)) return false;
        if (!secondName.equals(user.secondName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name!=null? name.hashCode() :17;
        result = 31 * result + (secondName!= null ? secondName.hashCode() : 17);
        result = 31 * result + cellphone;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", cellphone=" + cellphone +
                '}';
    }
}
