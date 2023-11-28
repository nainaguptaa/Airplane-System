package controller;

import model.flight.Booking;
import model.flight.SeatType;
import view.SeatView;
import ViewModel.SeatViewModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.awt.event.ActionListener;

public class SeatController implements ActionListener{

    private Database db;
    private MainController mc;
    private ArrayList<SeatViewModel> seatViewModels;
    private Booking booking;

    private SeatView seatView;

    public SeatController(Database db, MainController mc, Map<String, Object> args) {
        this.db = db;
        this.mc = mc;
        this.seatViewModels = new ArrayList<>();
        try {
            this.booking = (Booking) args.get("booking");
            // Use the retrievedBooking object as needed
        } catch (ClassCastException e) {
            // Handle the case where the object is not of type Booking
            System.err.println("The object retrieved from 'args' is not a Booking");
        }

        seatView = new SeatView(getSeatViewModels());
        seatView.display(seatView);
        addListeners();
    }

    private void addListeners(){
        seatView.addConfirmListener(this);
    }

    public ArrayList<SeatViewModel> getSeatViewModels() {
        int aircraftId = getAircraftID(booking);

        if (aircraftId == -1) {
            return seatViewModels;
        }

        String query = "SELECT seat_number, is_available, class FROM seats WHERE aircraft_id = '" + aircraftId + "';";
        try (ResultSet rs = db.executeQuery(query);) {
            while (rs.next()) {
                String seatNumber = rs.getString("seat_number");
                boolean isAvailable = rs.getBoolean("is_available");
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

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String seatNumber = seatView.getSelectedSeatId();
        booking.setSeatId(Integer.parseInt(seatNumber.substring(1)));
        HashMap<String, Object> args = new HashMap<>();
        args.put("booking", booking);   
        mc.switchToViewWithArgs("PaymentView", args);
    }

    public SeatView getView() {
        return seatView;
    }
}
