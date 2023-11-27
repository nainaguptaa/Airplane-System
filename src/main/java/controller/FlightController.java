package controller;

import model.flight.Booking;
import utils.Views;
import view.FlightView;
import viewModel.FlightViewModel;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightController implements ActionListener {
    private Database db;
    private MainController mainController;
    private FlightViewModel[] flightViewModel;

    private FlightView flightView;

    public FlightController(Database db, MainController mc) {
        this.db = db;
        this.mainController = mc;

        flightView = new FlightView(getFlightViewModels());
        flightView.addFlightSelectionListener(this);
    }

    public FlightView getView() {
        return flightView;
    }

    public FlightViewModel[] getFlightViewModels() {

        String query = "SELECT "
                + "flight_id, "
                + "departure_time, "
                + "arrival_time, "
                + "price, "
                + "departure_airport_id, "
                + "arrival_airport_id "
                + "FROM flights";
        ResultSet res = db.executeQuery(query);

        try {
            List<FlightViewModel> flightList = new ArrayList<>();
            while (res.next()) {
                int flightId = res.getInt("flight_id");
                String departureTime = res.getString("departure_time");
                String arrivalTime = res.getString("arrival_time");
                int price = res.getInt("price");
                String departureAirportId = res.getString("departure_airport_id");
                String arrivalAirportId = res.getString("arrival_airport_id");

                flightList.add(new FlightViewModel(flightId, arrivalAirportId, departureAirportId, departureTime, arrivalTime, price, flightId + ""));
            }
            flightViewModel = flightList.toArray(new FlightViewModel[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flightViewModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedRow = e.getActionCommand();
        HashMap<String, Object> args = new HashMap<>();
        FlightViewModel flight = flightViewModel[Integer.parseInt(selectedRow)];
        String username = null;

        if (mainController.getUser().getRole() != 1) {
            username = mainController.getUser().getUsername();
        }

        // Create a new booking object and pass it to the next view
        Booking booking = new Booking(0, flight.FlightId, username, 0, false, flight.Price, null);
        args.put("booking", booking);

        if (username == null) {
            JOptionPane.showMessageDialog(null, "You must be logged in to book a flight", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            mainController.switchToViewWithArgs("SeatMapView", args);
        }
    }
}
