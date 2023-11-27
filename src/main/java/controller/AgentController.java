package controller;

import model.role.User;
import viewModel.AgentView;
import viewModel.FlightViewModel;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AgentController {
    // include method for browsing passengers in a flight
    private Database db;
    private MainController mc;
    private User model;
    private AgentView view;

    private ArrayList<FlightViewModel> flightViewModels;

    public AgentController(Database db, MainController mc) {
        this.db = db;
        this.mc = mc;
        this.model = mc.getUser();
        this.view = new AgentView(getFlightViewModels());
    }

    public ArrayList<FlightViewModel> getFlightViewModels() {

        String query = "SELECT * FROM flights WHERE flight_id IN (SELECT flight_id FROM crew WHERE username = '"
                + mc.getUser().getUsername() + "');";
        try (ResultSet rs = db.executeQuery(query);) {
            while (rs.next()) {
                int flightId = rs.getInt("flight_id");
                String arrivalTime = rs.getString("arrival_time");
                String departureTime = rs.getString("departure_time");
                String destination = rs.getString("arrival_airport_id");
                String leavingFrom = rs.getString("departure_airport_id");
                double price = rs.getDouble("price");
                this.flightViewModels.add(new FlightViewModel(flightId, destination, leavingFrom, departureTime,
                        arrivalTime, price, Integer.toString(flightId)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightViewModels;
    }

    public AgentView getView() {
        return view;
    }
}
