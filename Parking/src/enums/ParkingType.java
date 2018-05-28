package src.enums;

/**
 * Created by msharafat on 2/4/18.
 */
public enum ParkingType {
    BIG("big"),
    MEDIUM("medium"),
    SMALL("small");


    String value;

    ParkingType(String value){
        this.value = value;
    }
}
