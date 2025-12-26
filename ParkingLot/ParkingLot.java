package ParkingLots.ParkingLot;

import java.util.List;

public class ParkingLot {

    List<ParkingFloor> floors;
    ParkingLot(List<ParkingFloor> floors){
        this.floors=floors;
    }
    Ticket parkVehicle(Vehicle vehicle){
        for( ParkingFloor floor: floors){
            ParkingSpot spot=floor.findAvailableSpot(vehicle);
            if(spot!=null){
                spot.park(vehicle);
                return new Ticket(vehicle,spot);
            }
        }
        return null;
    }

    void unparkVehicle(Ticket ticket){
        ticket.spot.unpark();
        ticket.closeTicket();
    }
}
