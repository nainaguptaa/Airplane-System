package controller;

import java.awt.event.ActionListener;
import view.ManageFlightsView;
import java.awt.event.ActionEvent;
import view.ManageFlightView;
import java.sql.ResultSet;
import model.flight.Flight;

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
            mfView.addSubmitButtonListener(this);
            mainController.switchToView("ManageFlightView");
        }
        else if (e.getActionCommand().equals("Remove Flight")) {
            removeFlight();
        }
        else if (e.getActionCommand().equals("Change Flight") && view.getFlightID() != null) {
            getFlightData();
            mfView = new ManageFlightView();
            updateMFView();
            mfView.addSubmitButtonListener(this);
            mainController.switchToView("ManageFlightView");
        }
        else if (e.getActionCommand().equals("Submit")) {
            
        }

    }

    private void getFlightData() {
        String query = "SELECT * FROM flights WHERE flightID = '" + view.getFlightID() + "'";
        ResultSet rs = db.executeQuery(query);

        try {
            if (rs != null) {
                if(rs.next()){
                    model.setFlightId(rs.getInt("flightID"));
                    model.setAircraftId(rs.getInt("aircraft_id"));
                    model.setOriginId(rs.getString("departure_airport_id"));
                    model.setDestinationId(rs.getString("arrival_airport_id"));
                    model.setDepartureTime(rs.getString("departureTime"));
                    model.setArrivalTime(rs.getString("arrivalTime"));
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
        String query = "DELETE FROM flights WHERE flightID = '" + view.getFlightID() + "'";
        db.executeUpdate(query);
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
