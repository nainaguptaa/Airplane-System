package controller;

import view.BookingsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.flight.Booking;

public class BookingsController implements ActionListener{
    BookingsView view;
    MainController mainController;
    Database db;
    ArrayList<String[]> bookings;

    public BookingsController(Database db, MainController mc) {
        this.mainController = mc;
        this.db = db;
        bookings = new ArrayList<>();
        view = new BookingsView();
        addListeners();
        getBookings();
    }


    private void addListeners() {
        view.addManageButtonListener(this);
        view.addCancelButtonListener(this);
    }

    private void getBookings() {
        // Get bookings from database
        String query = "SELECT * FROM bookings WHERE username = '" + mainController.getUser().getUsername() + "'";
        ResultSet rs = db.executeQuery(query);
        try{
            while(rs.next()){
                Booking booking = new Booking(
                    rs.getInt("bookingID"),
                    rs.getInt("flightID"),
                    rs.getString("username"),
                    rs.getInt("seat"),
                    rs.getString("insurance"),
                    rs.getDouble("price"),
                    rs.getString("bookingTime")
                );
                bookings.add(booking.getBookingData());
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            mainController.switchToView("UserView");
        } else if (e.getActionCommand().equals("Book")) {
            // Book
        }
    }

    public BookingsView getView() {
        return view;
    }
}
