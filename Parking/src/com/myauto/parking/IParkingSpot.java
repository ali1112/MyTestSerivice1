package src.com.myauto.parking;


import java.time.LocalDateTime;

/**
 * Created by msharafat on 2/4/18.
 */
public interface IParkingSpot {
    boolean isFree();
    String getSize();
    void occupy();
    void vacant();
    LocalDateTime getInDateTime();
    LocalDateTime getOUtDateTime();
    Integer getSlotCharge();

}
