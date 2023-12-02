package controller;

import model.flight.Booking;
import view.FlightView;
import ViewModel.FlightViewModel;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The FlightController class manages user interactions with the flight view,
 * allowing users to select a flight and proceed with booking.
 */
public class FlightController implements ActionListener {
    private Database db;
    private MainController mainController;
    private FlightViewModel[] flightViewModel;

    private FlightView flightView;

    /**
     * Constructs a FlightController.
     *
     * @param db           The database instance for data retrieval.
     * @param mainController The main controller for managing views and navigation.
     */
    public FlightController(Database db, MainController mc) {
        this.db = db;
        this.mainController = mc;

        flightView = new FlightView(getFlightViewModels());
        flightView.addFlightSelectionListener(this);
    }

    /**
     * Gets the FlightView associated with this controller.
     *
     * @return The FlightView instance.
     */
    public FlightView getView() {
        return flightView;
    }

    /**
     * Retrieves flight view models from the database.
     *
     * @return An array of FlightViewModel objects representing flights.
     */
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

                flightList.add(new FlightViewModel(flightId, arrivalAirportId, departureAirportId, departureTime,
                        arrivalTime, price, flightId + ""));
            }
            flightViewModel = flightList.toArray(new FlightViewModel[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flightViewModel;
    }

    /**
     * Handles user actions when a flight is selected for booking.
     *
     * @param e The ActionEvent representing the flight selection.
     */
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
            JOptionPane.showMessageDialog(null, "You must be logged in to book a flight", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            mainController.switchToViewWithArgs("SeatMapView", args);
        }
    }
}
