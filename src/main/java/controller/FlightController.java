package controller;

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

//    public FlightViewModel[] getFlightViewModels() {
//
//        FlightViewModel[] flightViewModel = new FlightViewModel[3];
//        flightViewModel[0] = new FlightViewModel("YYC", "YQR", "3:00PM", "4:00PM", "$300.00",
//                "AC123");
//
//        flightViewModel[1] = new FlightViewModel("YQR", "YYC", "5:00PM", "6:00PM", "$300.00",
//                "AC124");
//
//        flightViewModel[2] = new FlightViewModel("YQR", "YYZ", "7:00PM", "8:00PM", "$300.00",
//                "AC125");
//
//        return flightViewModel;
//    }

    public FlightViewModel[] getFlightViewModels() {
        String query = "SELECT " +
                "a1.code AS departure_airport_code, " +
                "a2.code AS arrival_airport_code, " +
                "f.departure_time, " +
                "f.arrival_time, " +
                "f.price, " +
                "CONCAT(a.model, f.flight_id) AS flight_number " +
                "FROM flights f " +
                "JOIN airports a1 ON f.departure_airport_id = a1.airport_id " +
                "JOIN airports a2 ON f.arrival_airport_id = a2.airport_id " +
                "JOIN aircrafts a ON f.aircraft_id = a.aircraft_id";

        List<FlightViewModel> flightList = new ArrayList<>();
        try {
            ResultSet rs = db.executeQuery(query);
            while (rs.next()) {
                String departureCode = rs.getString("departure_airport_code");
                String arrivalCode = rs.getString("arrival_airport_code");
                String departureTime = rs.getString("departure_time"); // Adjust format as needed
                String arrivalTime = rs.getString("arrival_time"); // Adjust format as needed
                String price = "$" + rs.getString("price");
                String flightNumber = rs.getString("flight_number");

                flightList.add(new FlightViewModel(departureCode, arrivalCode, departureTime, arrivalTime, price, flightNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flightList.toArray(new FlightViewModel[0]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedRow = e.getActionCommand();
        HashMap<String, Object> args = new HashMap<>();
        args.put("flight", flightViewModel[Integer.parseInt(selectedRow)]);
        mainController.switchToViewWithArgs("SeatMapView", args);
    }
}
