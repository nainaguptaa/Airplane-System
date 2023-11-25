package controller;

import model.flight.Booking;
import model.flight.Seat;
import view.SeatView;
import viewModel.SeatViewModel;
import java.util.ArrayList;

public class SeatController {
    // include method for adding/removing seats
    // include method for updating seat availability

    private Database db;
    private MainController mc;
    private ArrayList<SeatViewModel> seatViewModels;
    private Booking booking;

    private SeatView seatView;

    public SeatController(Database db, MainController mc, Booking userBooking) {
        this.db = db;
        this.mc = mc;
        this.booking = userBooking;

        // seatView = new SeatView(getSeatViewModels());
    }

    public ArrayList<SeatViewModel> getSeatViewModels() {
        /*
         * Write a SQL query to retrieve all seat data and store the necessary data into
         * an array
         * This array is then to be passed into seat view so that it can use the array
         * to check what seats
         * are already taken and which seats are available.
         * 
         * For the query, use the booking passed into seat controller to retrieve the
         * corresponding flight id
         * then using the flight id search through the flights sql table to retrieve the
         * aircraft id,
         * then using the aircraft id grab all relevant entries in the seat table and
         * put them into an array
         * of seats, and then pass this array of seats to seatview for creating the
         * seats.
         */
        String query = "SELECT aircraft_id FROM flights WHERE flight_id = '" + booking.getFlightId() + "';";

        return seatViewModels;
    }

    public SeatView getSeatView() {
        return seatView;
    }
}
