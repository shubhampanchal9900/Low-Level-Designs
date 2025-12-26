package ParkingLots.ParkingLot;

import java.util.List;

public class ParkingFloor {

    int floorNumber;
    List<ParkingSpot> spots;

    ParkingFloor(int floorNumber,List<ParkingSpot> spots){
        this.floorNumber=floorNumber;
        this.spots=spots;
    }

    ParkingSpot findAvailableSpot(Vehicle vehicle){
        for(ParkingSpot spot: spots){
            if(spot.canFit(vehicle)){
                return spot;
            }
        }
        return null;
    }



}
