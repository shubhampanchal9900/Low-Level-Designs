package ParkingLots.ParkingLot;

import java.time.LocalDateTime;

public class Ticket {
    Vehicle vehicle;
    ParkingSpot spot;
    LocalDateTime entryTime;
    LocalDateTime exitTime;

    Ticket(Vehicle vehicle,ParkingSpot spot){
        this.vehicle=vehicle;
        this.spot=spot;
        this.entryTime= LocalDateTime.now();
    }

    void closeTicket(){
        this.exitTime=LocalDateTime.now();
    }
}
