/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_5.ShortP107;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class Reservation {
    private String bookingID;
    private String customerName;
    private String  phoneNumber;
    private String roomNumber;
    private LocalDate bookingDate;
    private FlightInformation flightInfor;
    
    public Reservation(String bookingId, String customerName, String phoneNumber, String roomNumber, LocalDate bookingdate, FlightInformation flightInformation){
        this.bookingID = bookingId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.bookingDate = bookingDate;
        this.flightInfor = flightInformation;
    }
    public Reservation(){
        bookingID = " ";
        customerName = " ";
        phoneNumber = "0000000000";
        roomNumber = " ";
        bookingDate = LocalDate.now();
        flightInfor = new FlightInformation();
        
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public FlightInformation getFlightInfor() {
        return flightInfor;
    }

    public void setFlightInfor(FlightInformation flightInfor) {
        this.flightInfor = flightInfor;
    }

    @Override
     public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Booking ID: " + bookingID +
               " | Name: " + customerName +
               " | Phone: " + phoneNumber +
               " | Room: " + roomNumber +
               " | Date: " + bookingDate.format(formatter) +
               " | " + flightInfor;
    }
    
}
