package controller;

import model.flight.Booking;
import model.flight.SeatType;
import utils.EmailSender;
import view.PaymentView;
import ViewModel.PaymentViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Controller class for managing payments and confirming flight bookings.
 */
public class PaymentController implements ActionListener {
    private PaymentView paymentView;
    private PaymentViewModel paymentModel;
    private MainController mainController;
    private Database db;
    private Booking booking;

    /**
     * Constructs a PaymentController with the given database, MainController, and arguments.
     *
     * @param db   The database instance to interact with.
     * @param mc   The MainController for switching views.
     * @param args A map of arguments, typically containing the booking to be paid.
     */
    public PaymentController(Database db, MainController mc, Map<String, Object> args) {
        this.mainController = mc;
        this.db = db;
        this.booking = (Booking) args.get("booking");

        if (booking == null) {
            System.err.println("The object retrieved from 'args' is not a Booking");
        }

        this.paymentView = new PaymentView(updateModel());
        paymentView.addConfirmPaymentListener(this);
    }

    /**
     * Updates the payment model with pricing and discount information.
     *
     * @return The updated PaymentViewModel.
     */
    private PaymentViewModel updateModel() {
        double flightPrice = booking.getPrice();
        try {
            String query1 = "SELECT * FROM promotion WHERE price_for_discount <= " + flightPrice +
                    " ORDER BY discount DESC LIMIT 1";

            ResultSet rs1 = db.executeQuery(query1);
            if (rs1 != null && rs1.next()) {
                double discount = mainController.getUser().getMember() ? rs1.getDouble("discount") : 0.0;
                // Update paymentModel with the obtained discount
                paymentModel = new PaymentViewModel(0, booking.getPrice(), 0.05 * booking.getPrice(),
                        mainController.getUser().getMember(), discount);
            }

            String query2 = "SELECT class FROM seats where seat_id = " + booking.getSeatId();
            ResultSet rs2 = db.executeQuery(query2);
            if (rs2 != null && rs2.next()) {
                String seatClass = rs2.getString("class");
                paymentModel.setSeatPrice(SeatType.getPriceByType(seatClass));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paymentModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (paymentView.validateCardInfo()) {
            updateDatabase();
            sendConfirmationEmail();
            JOptionPane.showMessageDialog(paymentView, "Congratulations! Your booking has been confirmed!");
            mainController.switchToView("UserView");
        } else {
            JOptionPane.showMessageDialog(paymentView, "Please enter all information.");
        }
    }

    /**
     * Sends a confirmation email to the user after a successful payment.
     */
    private void sendConfirmationEmail() {
        String emailContent = "Your payment has been confirmed.\n" +
                "Flight Details: " + booking.getFlightId() + "\n" +
                "Seat Details: " + booking.getSeatId() + "\n" +
                "Price: " + paymentView.getFinalPrice() + "\n" +
                "Cancellation: " + (paymentView.getCancellation() != 0.0 ? "Insured" : "Not Insured") + "\n";
        EmailSender.sendEmail(mainController.getUser().getEmail(), "Payment Confirmation - " + mainController.getUser().getUsername(), emailContent);
    }

    /**
     * Updates the database with the confirmed booking and payment information.
     */
    private void updateDatabase() {
        String username = mainController.getUser().getUsername();
        int flightId = booking.getFlightId();
        int seatId = booking.getSeatId();
        boolean insurance = paymentView.getCancellation() != 0.0;
        double price = paymentView.getFinalPrice();

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
                pstmt.setString(6, "Confirmed");
                pstmt.executeUpdate();
            }

            // Update the seat status to 'taken'
            String updateSeatSql = "UPDATE seats SET is_available = false WHERE seat_id = ?";
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

    /**
     * Gets the PaymentView associated with this controller.
     *
     * @return The PaymentView.
     */
    public PaymentView getView() {
        return paymentView;
    }
}
