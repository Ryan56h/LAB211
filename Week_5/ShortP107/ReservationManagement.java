/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_5.ShortP107;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ReservationManagement {
   
    private List<Reservation> reservations = new ArrayList<>();
    private ReservationView view = new ReservationView();
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy" + " HH:mm");

    public void start() {
        while (true) {
            view.showMessage("*** Reservation Management ***");
            view.showMessage("1. Create new reservation\n2. Update reservation\n3. Delete reservation\n4. Print Flight Information\n5. Print all\n6. Exit");
            String choice = view.getInput("You choose: ");

            switch (choice) {
                case "1": createReservation(); break;
                case "2": updateReservation(); break;
                case "3": deleteReservation(); break;
                case "4": printFlightInfo(); break;
                case "5": view.printReservations(reservations); break;
                case "6": view.showMessage("BYE AND SEE YOU NEXT TIME"); return;
                default: view.showMessage("Invalid choice. Try again.");
            }
        }
    }

    private void createReservation() {
        String bookingID = view.getInput("ID: ", 6);
        String name = view.getInput("Name: ", "[a-zA-Z ]+");
        String phone = view.getInput("Phone: ", 12);
        String room = view.getInput("RoomNumbers: ", 4);
        String dateStr = view.getInput("BookingDate (dd/MM/yyyy): ");

        try {
            LocalDate bookingDate = LocalDate.parse(dateStr, dateFormatter);
            if (bookingDate.isBefore(LocalDate.now())) {
                throw new Exception("Booking date must be after today.");
            }

            FlightInformation flightInfo = null;
            String response = view.getInput("Need airport pick up? (Y/N): ");
            if ("Y".equalsIgnoreCase(response)) {
                String flight = view.getInput("Flight: ");
                String seat = view.getInput("Seat: ");
                LocalDateTime timePickUp;

                while (true) {
                    try {
                        String pickupStr = view.getInput("TimePickUp (dd/MM/yyyy HH:mm): ");
                        timePickUp = LocalDateTime.parse(pickupStr, dateTimeFormatter);

                        if (timePickUp.isBefore(LocalDateTime.now()) || timePickUp.isAfter(bookingDate.atTime(23, 59))) {
                            view.showMessage("Pickup time must be between now and the booking date. Try again.");
                            continue;
                        }

                        break;
                    } catch (DateTimeParseException e) {
                        view.showMessage("Invalid format! Please enter time in 'dd/MM/yyyy HH:mm'.");
                    }
                }

                flightInfo = new FlightInformation(flight, seat, timePickUp);
            }

            reservations.add(new Reservation(bookingID, name, phone, room, bookingDate , flightInfo));
            view.showMessage("Information saved successfully.");
        } catch (Exception e) {
            view.showMessage(" Data input is invalid: " + e.getMessage());
        }

    }

    private void updateReservation() {
        while (true) {
            String id = view.getInput("ID: ");
            Reservation reservationToUpdate = null;


            for (Reservation r : reservations) {
                if (r.getBookingID().equals(id)) {
                    reservationToUpdate = r;
                    break;
                }
            }


            if (reservationToUpdate == null) {
                view.showMessage("No information found.");
                String retry = view.getInput("You want to find again? (Y/N): ");
                if (!retry.equalsIgnoreCase("Y")) return;
                continue;
            }


            view.showMessage("\nCurrent Information:");
            showReservationDetails(reservationToUpdate);

            view.showMessage("\nIf you do not want to change the information, just press enter to skip.");


            String newName = view.getInput("Name: ");
            if (!newName.isEmpty()) reservationToUpdate.setCustomerName(newName);

            String newPhone = view.getInput("Phone: ");
            if (!newPhone.isEmpty()) reservationToUpdate.setPhoneNumber(newPhone);

            String newRoom = view.getInput("RoomNumbers: ");
            if (!newRoom.isEmpty()) reservationToUpdate.setRoomNumber(newRoom);

            String newDateStr = view.getInput("BookingDate (dd/MM/yyyy): ");
            if (!newDateStr.isEmpty()) {
                try {
                    LocalDate newBookingDate = LocalDate.parse(newDateStr, dateFormatter);
                    if (newBookingDate.isBefore(LocalDate.now())) {
                        view.showMessage("Booking date must be after today. Keeping old date.");
                    } else {
                        reservationToUpdate.setBookingDate(newBookingDate);
                    }
                } catch (DateTimeParseException e) {
                    view.showMessage("Invalid date format! Keeping old date.");
                }
            }


            String response = view.getInput("Need airport pick up? (Y/N): ");
            FlightInformation flightInfo = reservationToUpdate.getFlightInfor();

            if ("Y".equalsIgnoreCase(response)) {
                if (flightInfo == null) {
                    flightInfo = new FlightInformation("", "", null);
                }
                String flight = view.getInput("Flight: ");
                if (!flight.isEmpty()) flightInfo.setFlightNumber(flight);

                String seat = view.getInput("Seat: ");
                if (!seat.isEmpty()) flightInfo.setSeatNumber(seat);

                LocalDateTime timePickUp;
                while (true) {
                    try {
                        String pickupStr = view.getInput("TimePickUp (dd/MM/yyyy HH:mm): ");
                        if (pickupStr.isEmpty()) break;

                        timePickUp = LocalDateTime.parse(pickupStr, dateTimeFormatter);

                        if (timePickUp.isBefore(LocalDateTime.now()) ||
                                (reservationToUpdate.getBookingDate() != null &&
                                        timePickUp.isAfter(reservationToUpdate.getBookingDate().atTime(23, 59)))) {
                            view.showMessage("Pickup time must be between now and the booking date. Try again.");
                            continue;
                        }

                        flightInfo.setTimePickUp(timePickUp);
                        break;
                    } catch (DateTimeParseException e) {
                        view.showMessage("Invalid format! Please enter time in 'dd/MM/yyyy HH:mm'.");
                    }
                }
                reservationToUpdate.setFlightInfor(flightInfo);
            }


            view.showMessage("\nUpdated Information:");
            showReservationDetails(reservationToUpdate);
            view.showMessage("Information saved successfully.");
            return;
        }
    }

    private void showReservationDetails(Reservation r) {
        String flightDetails = "N/A";
        if (r.getFlightInfor() != null) {
            flightDetails = r.getFlightInfor().getFlightNumber() + " - " +
                    r.getFlightInfor().getSeatNumber() + " - " +
                    (r.getFlightInfor().getTimePickUp() != null ? r.getFlightInfor().getTimePickUp().format(dateTimeFormatter) : "N/A");
        }

        view.showMessage("\nID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
        view.showMessage(r.getBookingID() + " - " + r.getCustomerName() + " - " +
                r.getPhoneNumber() + " - " + r.getRoomNumber() + " - " +
                r.getBookingDate().format(dateFormatter) + " - " + flightDetails);
    }


    private void deleteReservation() {
        String id = view.getInput("ID: ");
        reservations.removeIf(r -> r.getBookingID().equals(id));
        view.showMessage("Information deleted successfully.");
    }

    private void printFlightInfo() {
        view.showMessage("*** Flight Information ***");
        for (Reservation r : reservations) {
            if (r.getFlightInfor()!= null) {
                view.showMessage(r.getBookingID() + " - " + r.getCustomerName() + " - " + r.getFlightInfor().getFlightNumber() + " - " + r.getFlightInfor().getSeatNumber() + " - " + r.getFlightInfor().getTimePickUp());
            }
        }
    }
}

