package src.com.myauto.parking;

import java.time.LocalDateTime;

/**
 * Created by msharafat on 2/4/18.
 */
public class SmallParkingSpot implements IParkingSpot {
    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String getSize() {
        return null;
    }

    @Override
    public void occupy() {

    }

    @Override
    public void vacant() {

    }

    @Override
    public LocalDateTime getInDateTime() {
        return null;
    }

    @Override
    public LocalDateTime getOUtDateTime() {
        return null;
    }

    @Override
    public Integer getSlotCharge() {
        return null;
    }
}
