package controller;

import java.awt.event.ActionListener;
import view.ManageFlightsView;
import java.awt.event.ActionEvent;
import view.ManageFlightView;

import java.sql.Date;
import java.sql.ResultSet;
import model.flight.Flight;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ManageFlightsController implements ActionListener {
    private ManageFlightsView view;
    private ManageFlightView mfView;
    private Database db;
    private MainController mainController;
    private Flight model;

    public ManageFlightsController(Database db, MainController mc) {
        this.mainController = mc;
        this.view = new ManageFlightsView();
        this.db = db;
        this.model = new Flight();
        getFlightDropdown();

        addListeners();
    }

    private void addListeners() {
        view.addAddFlightButtonListener(this);
        view.addRemoveFlightButtonListener(this);
        view.addChangeFlightButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("Add Flight")) {
            mfView = new ManageFlightView();
            getDropdowns();
            mfView.addSubmitButtonListener(this);
            mainController.switchToView("ManageFlightView");
        } else if (e.getActionCommand().equals("Remove Flight")) {
            removeFlight();
        } else if (e.getActionCommand().equals("Change Flight") && view.getFlightID() != null) {
            getFlightData();
            mfView = new ManageFlightView();
            getDropdowns();
            updateMFView();
            mfView.addSubmitButtonListener(this);
            mainController.switchToView("ManageFlightView");
        } else if (e.getActionCommand().equals("Submit")) {
            saveFlight();
        }

    }

    private void getDropdowns() {
        getAircraftDropdown();
        getLocationDropdown();
    }

    private void getAircraftDropdown() {
        String query = "SELECT * FROM aircrafts";
        ResultSet rs = db.executeQuery(query);
        try {
            while (rs.next()) {
                mfView.addAircraftDropdownItem(rs.getString("aircraft_id"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void getLocationDropdown() {
        String query = "SELECT * FROM locations";
        ResultSet rs = db.executeQuery(query);
        try {
            while (rs.next()) {
                mfView.addOriginDropdownItem(rs.getString("code"));
                mfView.addDestinationDropdownItem(rs.getString("code"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void getFlightDropdown() {
        String query = "SELECT * FROM flights";
        ResultSet rs = db.executeQuery(query);
        try {
            while (rs.next()) {
                view.addFlightDropdownItem(rs.getString("flight_id"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void getFlightData() {
        String query = "SELECT * FROM flights WHERE flight_id = '" + view.getFlightID() + "'";
        ResultSet rs = db.executeQuery(query);

        try {
            if (rs != null) {
                if (rs.next()) {
                    model.setFlightId(rs.getInt("flight_id"));
                    model.setAircraftId(rs.getInt("aircraft_id"));
                    model.setOriginId(rs.getString("departure_airport_id"));
                    model.setDestinationId(rs.getString("arrival_airport_id"));
                    model.setDepartureTime(rs.getTimestamp("departure_time"));
                    model.setArrivalTime(rs.getTimestamp("arrival_time"));
                    model.setPrice(rs.getDouble("price"));
                } else {
                    System.out.println("Flight does not exist"); // Maybe make this an exception
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void removeFlight() {
        String query = "DELETE FROM flights WHERE flight_id = '" + view.getFlightID() + "'";
        db.executeUpdate(query);
    }

    private void saveFlight() {
        try {
            //retrieve all data from view
            model.setAircraftId(Integer.parseInt(mfView.getAircraft()));
            model.setOriginId(mfView.getOrigin());
            model.setDestinationId(mfView.getDestination());
            model.setDepartureTime(Date.from(mfView.getDepartureTime().atZone(ZoneId.systemDefault()).toInstant()));
            model.setArrivalTime(Date.from(mfView.getArrivalTime().atZone(ZoneId.systemDefault()).toInstant()));
            model.setPrice(Double.parseDouble(mfView.getPrice()));
            String query = new String();
            if (model.getFlightId() == 0){ //new flight
                query = "INSERT INTO flights (aircraft_id, departure_airport_id, arrival_airport_id, departure_time, arrival_time, price) VALUES ('"
                    + model.getAircraftId() + "', '"
                    + model.getOriginId() + "', '" + model.getDestinationId() + "', '" 
                    + model.getDepartureString() + "', '" + model.getArrivalString() + "', '" 
                    + model.getPrice() + "')";
            }
            else{
                query = "UPDATE flights SET aircraft_id = '" + model.getAircraftId() + "', departure_airport_id = '"
                    + model.getOriginId() + "', arrival_airport_id = '" + model.getDestinationId()
                    + "', departure_time = '" + model.getDepartureString() + "', arrival_time = '"
                    + model.getArrivalString()
                    + "', price = '" + model.getPrice() + "' WHERE flight_id = " + model.getFlightId();
            }
            int res = db.executeUpdate(query);
            if (res == 1) {
                mfView.addSuccessMessage();
                mainController.switchToView("ManageFlightsView");
            } else {
                mfView.addErrorMessage("There was an error saving the flight");
            }
        } catch (NullPointerException e) {
            mfView.addErrorMessage("Please fill out all fields");
        }
    }

    public void updateMFView() {
        mfView.updateView(model);
    }

    public ManageFlightsView getView() {
        return view;
    }

    public ManageFlightView getMFView() {
        return mfView;
    }

}
