package controller;

import model.flight.Booking;
import model.flight.SeatType;
import view.SeatView;
import ViewModel.SeatViewModel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.awt.event.ActionListener;

/**
 * Controller class for managing seat selection in a flight booking process.
 */
public class SeatController implements ActionListener {

    private Database db;
    private MainController mc;
    private ArrayList<SeatViewModel> seatViewModels;
    private Booking booking;

    private SeatView seatView;

    /**
     * Constructs a SeatController with the provided database, main controller, and arguments.
     *
     * @param db    The database instance to interact with.
     * @param mc    The main controller for switching views.
     * @param args  A map of arguments, which should contain a "booking" object.
     */
    public SeatController(Database db, MainController mc, Map<String, Object> args) {
        this.db = db;
        this.mc = mc;
        this.seatViewModels = new ArrayList<>();
        try {
            this.booking = (Booking) args.get("booking");
            // Use the retrieved Booking object as needed
        } catch (ClassCastException e) {
            // Handle the case where the object is not of type Booking
            System.err.println("The object retrieved from 'args' is not a Booking");
        }

        seatView = new SeatView(getSeatViewModels());
        seatView.display(seatView);
        addListeners();
    }

    /**
     * Adds action listeners to the SeatView components.
     */
    private void addListeners() {
        seatView.addConfirmListener(this);
    }

    /**
     * Retrieves and populates a list of SeatViewModels based on the aircraft and seat data.
     *
     * @return An ArrayList of SeatViewModel objects.
     */
    public ArrayList<SeatViewModel> getSeatViewModels() {
        int aircraftId = getAircraftID(booking);

        if (aircraftId == -1) {
            return seatViewModels;
        }

        String query = "SELECT seat_id, seat_number, is_available, class FROM seats WHERE aircraft_id = '" + aircraftId + "';";
        try (ResultSet rs = db.executeQuery(query)) {
            while (rs.next()) {
                String seatNumber = rs.getString("seat_number");
                boolean isAvailable = rs.getBoolean("is_available");
                String type = rs.getString("class");
                int seatId = rs.getInt("seat_id");

                SeatType seatType = SeatType.fromString(type);

                SeatViewModel seat = new SeatViewModel(seatId, seatType, isAvailable, seatNumber);
                seatViewModels.add(seat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return seatViewModels;
    }

    /**
     * Retrieves the aircraft ID associated with the booking.
     *
     * @param booking The Booking object for which to retrieve the aircraft ID.
     * @return The aircraft ID or -1 if not found.
     */
    public int getAircraftID(Booking booking) {
        int aircraftId = 0;
        String query = "SELECT aircraft_id FROM flights WHERE flight_id = '" + booking.getFlightId() + "';";
        ResultSet rs = db.executeQuery(query);
        try {
            if (rs.next()) {
                aircraftId = rs.getInt("aircraft_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return aircraftId;
    }

    /**
     * Handles actionPerformed events, typically triggered by seat selection confirmation.
     *
     * @param e The ActionEvent object.
     */
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        int seatNumber = seatView.getSelectedSeatId();
        booking.setSeatId(seatNumber);
        HashMap<String, Object> args = new HashMap<>();
        args.put("booking", booking);
        mc.switchToViewWithArgs("PaymentView", args);
    }

    /**
     * Gets the SeatView associated with this controller.
     *
     * @return The SeatView.
     */
    public SeatView getView() {
        return seatView;
    }
}
