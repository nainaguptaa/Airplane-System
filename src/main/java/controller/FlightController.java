package main.java.controller;

import main.java.view.FlightView;
import java.awt.event.*;

public class FlightController implements ActionListener {
    private Database db;
    private MainController mainController;

    private FlightView flightView;

    public FlightController(Database db, MainController mc) {
        this.db = db;
        this.mainController = mc;

        flightView = new FlightView();
        flightView.setVisible(true);

    }

    public void addListeners() {
    }

    public String[] getAllFlights() {
        return new String[] { "Flight 1", "Flight 2", "Flight 3" };
    }
    // include method for returning flights based on search criteria

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedRow = e.getActionCommand();
        System.out.println("Selected row: " + selectedRow);
    }
    // Include method for admin creating flight

    // include method for admin updating flight

    // include method for admin deleting flight

}
