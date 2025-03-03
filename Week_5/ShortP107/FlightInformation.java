/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_5.ShortP107;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class FlightInformation {
    private String flightNumber;
    private String seatNumber;
    private LocalDateTime timePickUp;
    
    public FlightInformation(String flightNumber , String seatNumber , LocalDateTime timePickUp){
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
        
    }
    public FlightInformation(){
        flightNumber = " ";
        seatNumber = " ";
        timePickUp = LocalDateTime.now();
        
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public LocalDateTime getTimePickUp() {
        return timePickUp;
    }

    public void setTimePickUp(LocalDateTime timePickUp) {
        this.timePickUp = timePickUp;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Flight: " + flightNumber + " | Seat: " + seatNumber + " | Time: " + timePickUp.format(formatter);
    }
    
    
    
}
