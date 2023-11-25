package controller;

import view.BookingsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.flight.Booking;
import utils.EmailSender;


public class BookingsController implements ActionListener{
    BookingsView view;
    MainController mainController;
    Database db;
    ArrayList<Booking> bookings;
    ArrayList<String[]> bookingsData;

    public BookingsController(Database db, MainController mc) {
        this.mainController = mc;
        this.db = db;
        bookings = new ArrayList<>();
        bookingsData = new ArrayList<>();
        getBookings();
        view = new BookingsView(bookingsData);
        addListeners();
    }


    private void addListeners() {
        view.addManageButtonListener(this);
        view.addCancelButtonListener(this);
        view.addTableListener(e -> view.updateButtons());
    }

    private void getBookings() {
        // Get bookings from database
        String query = "SELECT * FROM bookings WHERE username = '" + mainController.getUser().getUsername() + "'";
        ResultSet rs = db.executeQuery(query);
        try{
            while(rs.next()){
                Booking booking = new Booking(
                    rs.getInt("booking_id"),
                    rs.getInt("flight_id"),
                    rs.getString("username"),
                    rs.getInt("seat_id"),
                    rs.getBoolean("insurance"),
                    rs.getDouble("price"),
                    rs.getDate("booking_date")
                );
                bookings.add(booking);
                bookingsData.add(booking.getBookingData());
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Cancel")) {
            try{
                // Cancel
                int id = view.getSelectedBooking();
                Booking selectedBooking = null;
                // Get booking based on id
                for (int i = 0; i < bookings.size(); i++) {
                    if (bookings.get(i).getBookingId() == id) {
                        selectedBooking = bookings.get(i);
                        bookingsData.remove(i);
                        break;
                    }
                }

                String query = "DELETE FROM bookings WHERE booking_id = " + id;
                db.executeUpdate(query);
                view.updateTable(bookingsData);
                if (selectedBooking.getInsurance()){
                    EmailSender.sendEmail(mainController.getUser().getEmail(), "Booking Cancelled", "Your booking has been cancelled. You will be refunded the full amount.");
                } else {
                    EmailSender.sendEmail(mainController.getUser().getEmail(), "Booking Cancelled", "Your booking has been cancelled. You will be refunded the full amount minus the insurance fee.");
                }

                bookings.remove(selectedBooking);
            }
            catch(Exception ex){
                System.out.println(ex);
            } finally {
                view.updateButtons();
            }
        } else if (e.getActionCommand().equals("Manage")) {
            // Book
        }
    }

    public BookingsView getView() {
        return view;
    }
}
