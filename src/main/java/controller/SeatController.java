package controller;

import model.flight.Seat;
import view.SeatView;
import viewModel.SeatViewModel;

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

        // seatView = new SeatView(getSeatViewModels());
    }

    public SeatViewModel[] getSeatViewModels() {
        /*
         * Write a SQL query to retrieve all seat data and store the necessary data into
         * an array
         * This array is then to be passed into seat view so that it can use the array
         * to check what seats
         * are already taken and which seats are available.
         */

        SeatViewModel svm[] = new SeatViewModel[3];

        // Add fake data to test output

        return svm;
    }

    public SeatView getSeatView() {
        return seatView;
    }
}
