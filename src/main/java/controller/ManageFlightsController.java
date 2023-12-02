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

/**
 * Controller class for managing flights-related views and functionality.
 */
public class ManageFlightsController implements ActionListener {
    private ManageFlightsView view;
    private ManageFlightView mfView;
    private Database db;
    private MainController mainController;
    private Flight model;

    /**
     * Constructs a new ManageFlightsController with the given database and MainController.
     *
     * @param db The database instance to interact with.
     * @param mc The MainController for switching views.
     */
    public ManageFlightsController(Database db, MainController mc) {
        this.mainController = mc;
        this.view = new ManageFlightsView();
        this.db = db;
        this.model = new Flight();
        getFlightDropdown();

        addListeners();
    }

    /**
     * Adds action listeners to the relevant buttons in the view.
     */
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

    /**
     * Populates dropdowns in the ManageFlightView.
     */
    private void getDropdowns() {
        getAircraftDropdown();
        getLocationDropdown();
    }

    /**
     * Retrieves aircraft data and populates the aircraft dropdown in the ManageFlightView.
     */
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

    /**
     * Retrieves location data and populates the origin and destination dropdowns in the ManageFlightView.
     */
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

    /**
     * Retrieves flight data based on the selected flight ID.
     */
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

    /**
     * Removes a flight based on the selected flight ID.
     */
    private void removeFlight() {
        String query = "DELETE FROM flights WHERE flight_id = '" + view.getFlightID() + "'";
        int res = db.executeUpdate(query);
        if (res == 0) {
            view.addErrorMessage("Error removing flight");
            return;
        }
        view.addSuccessMessage("Flight removed successfully");
        view.clearFlightDropdown();
        getFlightDropdown();
    }

    /**
     * Retrieves flight IDs from the database and adds them to the view's dropdown.
     */
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



    /**
     * Saves flight data to the database.
     */
    private void saveFlight() {
        try {
            // Retrieve all data from the view
            model.setAircraftId(Integer.parseInt(mfView.getAircraft()));
            model.setOriginId(mfView.getOrigin());
            model.setDestinationId(mfView.getDestination());
            model.setDepartureTime(Date.from(mfView.getDepartureTime().atZone(ZoneId.systemDefault()).toInstant()));
            model.setArrivalTime(Date.from(mfView.getArrivalTime().atZone(ZoneId.systemDefault()).toInstant()));
            model.setPrice(Double.parseDouble(mfView.getPrice()));

            // Check validity of data
            if (model.getOriginId().equals(model.getDestinationId())) {
                mfView.addErrorMessage("Origin and destination cannot be the same");
                return;
            }
            if (model.getDepartureTime().after(model.getArrivalTime())) {
                mfView.addErrorMessage("Departure time cannot be after arrival time");
                return;
            }
            if (model.getPrice() < 0) {
                mfView.addErrorMessage("Price cannot be negative");
                return;
            }
            if (model.getAircraftId() == 0 || model.getOriginId().equals("") || model.getDestinationId().equals("")
                    || model.getDepartureTime() == null || model.getArrivalTime() == null) {
                mfView.addErrorMessage("Please fill out all fields");
                return;
            }

            String query = new String();
            if (model.getFlightId() == 0) { // New flight
                query = "INSERT INTO flights (aircraft_id, departure_airport_id, arrival_airport_id, departure_time, arrival_time, price) VALUES ('"
                        + model.getAircraftId() + "', '"
                        + model.getOriginId() + "', '" + model.getDestinationId() + "', '"
                        + model.getDepartureString() + "', '" + model.getArrivalString() + "', '"
                        + model.getPrice() + "')";
            } else {
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

    /**
     * Updates the ManageFlightView with flight data.
     */
    public void updateMFView() {
        mfView.updateView(model);
    }

    /**
     * Gets the ManageFlightsView associated with this controller.
     *
     * @return The ManageFlightsView.
     */
    public ManageFlightsView getView() {
        return view;
    }

    /**
     * Gets the ManageFlightView associated with this controller.
     *
     * @return The ManageFlightView.
     */
    public ManageFlightView getMFView() {
        return mfView;
    }
}
