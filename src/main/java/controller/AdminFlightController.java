package controller;

import view.AdminFlightView;
import ViewModel.FlightViewModel;
import view.CrewView;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

public class AdminFlightController implements ActionListener {
    private Database db;
    private MainController mainController;
    private FlightViewModel flightViewModel[];

    private AdminFlightView flightView;
    private CrewView crewView;

    public AdminFlightController(Database db, MainController mc) {
        this.db = db;
        this.mainController = mc;

        flightView = new AdminFlightView(getFlightViewModels());
        flightView.addFlightSelectionListener(this);
        flightView.addSearchButtonListener(this);
    }

    public AdminFlightView getView() {
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

    private void getFlightViewModels(LocalDate date){
        String query = "SELECT " 
                + "flight_id, "
                + "departure_time, "
                + "arrival_time, "
                + "price, "
                + "departure_airport_id, "
                + "arrival_airport_id "
                + "FROM flights "
                + "WHERE departure_time BETWEEN '" + date + " 00:00:00' AND '" + date + " 23:59:59'";
        
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
            flightView.updateTable(flightViewModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Search")) {
            getFlightViewModels(flightView.getDepartureDateSearch());
        } else {
            FlightViewModel flight = flightViewModel[Integer.parseInt(cmd)];
            Map<String, Object> args = new HashMap<>();
            args.put("flightNo", flight.FlightId);
            mainController.switchToViewWithArgs("CrewView", args);
        }
    }


}

