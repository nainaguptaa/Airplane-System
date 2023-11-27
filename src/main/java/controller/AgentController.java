package controller;

import model.flight.Booking;
import model.role.User;
import view.FlightView;
import view.PassengerView;
import viewModel.AgentView;
import viewModel.FlightViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.xdevapi.Result;

public class AgentController implements ActionListener {
    // include method for browsing passengers in a flight
    private Database db;
    private MainController mc;
    private User model;
    private PassengerView passengerView;
    private FlightView flightView;

    private FlightViewModel[] flightViewModels;

    public AgentController(Database db, MainController mc) {
        this.db = db;
        this.mc = mc;
        this.model = mc.getUser();
        this.flightView = new FlightView(getFlightViewModels());

        this.flightView.addFlightSelectionListener(this);
    }

    public FlightViewModel[] getFlightViewModels() {

        String query = "SELECT * FROM flights WHERE flight_id IN (SELECT flight_id FROM crew WHERE username = '"
                + mc.getUser().getUsername() + "');";
        try (ResultSet rs = db.executeQuery(query);) {
            List<FlightViewModel> flightList = new ArrayList<>();
            while (rs.next()) {
                int flightId = rs.getInt("flight_id");
                String arrivalTime = rs.getString("arrival_time");
                String departureTime = rs.getString("departure_time");
                String destination = rs.getString("arrival_airport_id");
                String leavingFrom = rs.getString("departure_airport_id");
                double price = rs.getDouble("price");
                flightList.add(new FlightViewModel(flightId, destination, leavingFrom, departureTime,
                        arrivalTime, price, Integer.toString(flightId)));
            }
            flightViewModels = flightList.toArray(new FlightViewModel[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightViewModels;
    }

    public PassengerView getPassengerView() {
        return passengerView;
    }

    public FlightView getFlightView() {
        return flightView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedRow = e.getActionCommand();
        FlightViewModel flight = flightViewModels[Integer.parseInt(selectedRow)];
        int flight_id = flight.FlightId;
        String selectUsernamesQuery = "SELECT username, seat_id FROM bookings WHERE flight_id = '" + flight_id + "';";
        Map<String, Integer> usersAndSeats = new HashMap<>();

        try (ResultSet rs = db.executeQuery(selectUsernamesQuery)) {
            while (rs.next()) {
                usersAndSeats.put(rs.getString("username"), rs.getInt("seat_id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        Map<String, ArrayList<String>> usersAndNames = new HashMap<>();
        ArrayList<String> names;
        for (Map.Entry<String, Integer> entry : usersAndSeats.entrySet()) {
            String selectNamesQuery = "SELECT first_name, last_name FROM users WHERE username = '" + entry.getKey()
                    + "';";
            try (ResultSet rs_names = db.executeQuery(selectNamesQuery)) {
                while (rs_names.next()) {
                    String firstName = rs_names.getString("first_name");
                    String lastName = rs_names.getString("last_name");
                    names = new ArrayList<>();
                    names.add(firstName);
                    names.add(lastName);
                    // Use the first name and last name as needed
                    usersAndNames.put(entry.getKey(), names);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        this.passengerView = new PassengerView(usersAndSeats, usersAndNames);
        mc.switchToView("PassengerTableView");
    }

}
