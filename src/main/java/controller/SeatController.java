package main.java.controller;

import main.java.model.flight.Seat;
import main.java.view.SeatView;
import main.java.viewModel.SeatViewModel;

public class SeatController {
    // include method for adding/removing seats
    // include method for updating seat availability

    private Database db;
    private MainController mc;
    private SeatViewModel seatViewModel[];

    private SeatView seatView;

    public SeatController(Database db, MainController mc) {
        this.db = db;
        this.mc = mc;

        seatView = new SeatView(getSeatViewModels());
    }

    public SeatViewModel[] getSeatViewModels() {
        // Write SQL query to get all seats and seat info

        SeatViewModel svm[] = new SeatViewModel[3];

        // Add fake data to test output

        return svm;
    }

    public SeatView getSeatView() {
        return seatView;
    }
}
