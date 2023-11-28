package controller;

import model.flight.Booking;
import utils.EmailSender;
import view.PaymentView;
import ViewModel.PaymentViewModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class PaymentController implements ActionListener {
    private PaymentView paymentView;
    private PaymentViewModel paymentModel;
    private MainController mainController;
    private Database db;
    private Booking booking;


    public PaymentController(Database db, MainController mc, Map<String, Object> args) {
        this.mainController = mc;
        this.db = db;
        this.booking = (Booking) args.get("booking");
        updateModel();

        this.paymentView = new PaymentView(paymentModel);

        paymentView.addConfirmPaymentListener(this);
    }

    private void updateModel() {
        double flightPrice = booking.getPrice();
        try {
            if (mainController.getUser().getMember()) {
                String query = "SELECT * FROM promotion WHERE price_for_discount <= " + flightPrice +
                        " ORDER BY discount DESC LIMIT 1";

                ResultSet rs = db.executeQuery(query);
                if (rs != null && rs.next()) {
                    double discount = rs.getDouble("discount");
                    // Update paymentModel with the obtained discount
                    paymentModel = new PaymentViewModel(0, booking.getPrice(), 0.05 * booking.getPrice(),
                            mainController.getUser().getMember(), discount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        EmailSender.sendEmail(mainController.getUser().getEmail(), "Payment Confirmation", "Your payment has been confirmed. Here is your ticket information:...\n");
        updateDatabase();
    }

    private void updateDatabase() {
        // Example data - replace these with actual data from your application context
        String username = mainController.getUser().getUsername();
        int flightId = booking.getFlightId();
        int seatId = booking.getSeatId();
        boolean insurance = false; // paymentView.getInsuranceCheckBox(); // paymentView.getInsurance();
        double price = 0; // paymentView.getTotalPrice();

        try {
            // Start a transaction
            db.getConnection().setAutoCommit(false);

            // Insert a new booking
            String insertBookingSql = "INSERT INTO bookings (username, flight_id, seat_id, insurance, price, status) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = db.getConnection().prepareStatement(insertBookingSql)) {
                pstmt.setString(1, username);
                pstmt.setInt(2, flightId);
                pstmt.setInt(3, seatId);
                pstmt.setBoolean(4, insurance);
                pstmt.setDouble(5, price);
                pstmt.setString(6, "confirmed");
                pstmt.executeUpdate();
            }

            // Update the seat status to 'taken'
            String updateSeatSql = "UPDATE seats SET status = 'taken' WHERE seat_id = ?";
            try (PreparedStatement pstmt = db.getConnection().prepareStatement(updateSeatSql)) {
                pstmt.setInt(1, seatId);
                pstmt.executeUpdate();
            }

            // Commit the transaction
            db.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                db.getConnection().rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                db.getConnection().setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public PaymentView getView() {
        return paymentView;
    }

}
