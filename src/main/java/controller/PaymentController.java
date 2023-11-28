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
        if (booking == null) {
            System.err.println("The object retrieved from 'args' is not a Booking");
        }
        this.paymentView = new PaymentView(updateModel());

        paymentView.addConfirmPaymentListener(this);

    }

    private PaymentViewModel updateModel() {
        double flightPrice = booking.getPrice();
        try {
            if (mainController.getUser().getMember()) {
                String query1 = "SELECT * FROM promotion WHERE price_for_discount <= " + flightPrice +
                        " ORDER BY discount DESC LIMIT 1";

                ResultSet rs1 = db.executeQuery(query1);
                if (rs1 != null && rs1.next()) {
                    double discount = rs1.getDouble("discount");
                    // Update paymentModel with the obtained discount
                    paymentModel = new PaymentViewModel(0, booking.getPrice(), 0.05 * booking.getPrice(),
                            mainController.getUser().getMember(), discount);
                }
                System.out.println("HERE 1:" + booking.getSeatId());
                String query2 = "SELECT class FROM seats where seat_id = " + booking.getSeatId();
                ResultSet rs2 = db.executeQuery(query2);
                if (rs2 != null && rs2.next()) {
                    String seatClass = rs2.getString("class");
                    System.out.println("HERE 2:" + seatClass);
                    paymentModel.setSeatPrice(SeatType.getPriceByType(seatClass));
                }
                System.out.println("HERE 3:" + paymentModel.getSeatPrice());

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

    private void sendConfirmationEmail() {
        String emailContent = "Your payment has been confirmed.\n" +
                "Booking ID: " + booking.getBookingId() + "\n" + // This booking id wont work
                "Flight Details: ...";
        EmailSender.sendEmail(mainController.getUser().getEmail(), "Payment Confirmation", emailContent);
    }

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

    public PaymentView getView() {
        return paymentView;
    }

}
