package ua.com.naukma.hotel.domain.model;

/**
 * Created by ihor on 18.02.2016.
 */
public class Greeting {

    private final int id;
    private final String name;

    public Greeting(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
