package controller;

import view.FlightView;
import viewModel.FlightViewModel;

import java.awt.event.*;

public class FlightController implements ActionListener {
    private Database db;
    private MainController mainController;
    private FlightViewModel flightViewModel[];

    private FlightView flightView;

    public FlightController(Database db, MainController mc) {
        this.db = db;
        this.mainController = mc;

        flightView = new FlightView(getFlightViewModels());
        // flightView.setVisible(true);

    }

    public FlightView getView() {
        return flightView;
    }

    public void addListeners() {
    }

    public FlightViewModel[] getFlightViewModels() {
        // Write SQL query to get all flights
        // String query = "SELECT * FROM flights";
        // blah blah blah
        // Fake it for now
        FlightViewModel fvm[] = new FlightViewModel[3];
        fvm[0] = new FlightViewModel("YYC", "YQR", "3:00PM", "4:00PM", "$300.00",
                "AC123");

        fvm[1] = new FlightViewModel("YQR", "YYC", "5:00PM", "6:00PM", "$300.00",
                "AC124");

        fvm[2] = new FlightViewModel("YQR", "YYZ", "7:00PM", "8:00PM", "$300.00",
                "AC125");

        return fvm;
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
