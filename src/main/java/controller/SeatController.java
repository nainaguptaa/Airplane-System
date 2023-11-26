package controller;

import model.flight.Booking;
import model.flight.SeatType;
import view.SeatView;
import viewModel.SeatViewModel;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SeatController {

    private Database db;
    private MainController mc;
    private ArrayList<SeatViewModel> seatViewModels;
    private Booking booking;

    private SeatView seatView;

    public SeatController(Database db, MainController mc, Booking userBooking) {
        this.db = db;
        this.mc = mc;
        this.booking = userBooking;

        seatView = new SeatView(getSeatViewModels());
        seatView.display(seatView);
    }

    public ArrayList<SeatViewModel> getSeatViewModels() {

        // Potentially change format of seat insertion in database (A0, B0, C0, D0, E0,
        // F0, A1, B1 , C1,etc.) to sort rows in order from top to bottom
        int aircraftId = getAircraftID(booking);

        if (aircraftId == -1) {
            return seatViewModels;
        }

        String query = "SELECT seat_number, available, class FROM seats WHERE aircraft_id = '" + aircraftId + "';";
        try (ResultSet rs = db.executeQuery(query);) {
            while (rs.next()) {
                String seatNumber = rs.getString("seat_number");
                Boolean isAvailable = rs.getBoolean("available");
                String type = rs.getString("class");

                SeatType seatType = SeatType.fromString(type);

                SeatViewModel seat = new SeatViewModel(seatNumber, seatType, isAvailable);
                seatViewModels.add(seat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return seatViewModels;
    }

    public int getAircraftID(Booking booking) {
        int aircraftId = 0;
        String query = "SELECT aircraft_id FROM flights WHERE flight_id = '" + booking.getFlightId() + "';";
        ResultSet rs = db.executeQuery(query);
        try {
            if (rs.next()) {
                aircraftId = rs.getInt("aircraft_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return aircraftId;
    }

    public SeatView getView() {
        return seatView;
    }
}
