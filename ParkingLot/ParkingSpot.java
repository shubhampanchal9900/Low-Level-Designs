package ParkingLots.ParkingLot;

public class ParkingSpot {

    SpotType type;
    boolean isFree;
    Vehicle vehicle;

    ParkingSpot(SpotType type){
        this.type=type;
    }

    boolean canFit(Vehicle vehicle){
        return isFree && type.name().equals(vehicle.type.name());
    }

    void park(Vehicle vehicle){
        this.vehicle=vehicle;
        this.isFree=false;
    }

    void unpark(){
        this.vehicle=vehicle;
        this.isFree=true;
    }

}
