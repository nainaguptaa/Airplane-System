package controller;

import model.flight.Booking;
import view.FlightView;
import viewModel.FlightViewModel;

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
    private FlightViewModel flightViewModel[];

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

        flightViewModel = new FlightViewModel[3];
        flightViewModel[0] = new FlightViewModel(0, "YYC", "YQR", "3:00PM", "4:00PM", 300,
                "AC123");

        flightViewModel[1] = new FlightViewModel(1, "YQR", "YYC", "5:00PM", "6:00PM", 300,
                "AC124");

        flightViewModel[2] = new FlightViewModel(2, "YQR", "YYZ", "7:00PM", "8:00PM", 321,
                "AC125");

        return flightViewModel;
    }

//    public FlightViewModel[] getFlightViewModels() {
//        String query = "SELECT " +
//                "f.flight_id, " +
//                "a1.code AS departure_airport_code, " +
//                "a2.code AS arrival_airport_code, " +
//                "f.departure_time, " +
//                "f.arrival_time, " +
//                "f.price, " +
//                "CONCAT(a.model, f.flight_id) AS flight_number " +
//                "FROM flights f " +
//                "JOIN airports a1 ON f.departure_airport_id = a1.airport_id " +
//                "JOIN airports a2 ON f.arrival_airport_id = a2.airport_id " +
//                "JOIN aircrafts a ON f.aircraft_id = a.aircraft_id";
//
//        List<FlightViewModel> flightList = new ArrayList<>();
//        try {
//            ResultSet rs = db.executeQuery(query);
//            while (rs.next()) {
//                int flightId = rs.getInt("flight_id"); // Get flightId
//                String departureCode = rs.getString("departure_airport_code");
//                String arrivalCode = rs.getString("arrival_airport_code");
//                String departureTime = rs.getString("departure_time"); // Adjust format as needed
//                String arrivalTime = rs.getString("arrival_time"); // Adjust format as needed
//                int price = rs.getInt("price");
//                String flightNumber = rs.getString("flight_number");
//
//                // Add flightId to your FlightViewModel constructor
//                flightList.add(new FlightViewModel(flightId, departureCode, arrivalCode, departureTime, arrivalTime, price, flightNumber));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return flightList.toArray(new FlightViewModel[0]);
//    }

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
            mainController.switchToViewWithArgs("InfoView", args);
        } else {
            mainController.switchToViewWithArgs("SeatMapView", args);
        }
    }
}
