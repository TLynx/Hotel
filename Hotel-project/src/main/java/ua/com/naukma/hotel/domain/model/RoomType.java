package ua.com.naukma.hotel.domain.model;

/**
 * Created by ihor on 21.02.2016.
 */
public enum RoomType {
    SINGLE_STANDARD(1),
    SINGLE_MODERATE(1),  //A SLIGHT BIT BETTER THAN STANDARD, BUT STILL NOT DELUXE
    SINGLE_DELUXE(1),
    DOUBLE_STANDARD(2),
    DOUBLE_MODERATE(2),
    DOUBLE_DELUXE(2),
    TRIPLE_STANDARD(3),
    TRIPLE_MODERATE(3),
    TRIPLE_DELUXE(3),
    QUAD_STANDARD(4),
    QUAD_DELUXE(4);

    private final int roominess;

    private RoomType(int roominess){
         this.roominess = roominess;
    }

    public int getRoominess() {
        return roominess;
    }
}
