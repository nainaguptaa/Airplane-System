package controller;

import model.flight.Booking;
import utils.EmailSender;
import view.PaymentView;
import ViewModel.PaymentViewModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class PaymentController implements ActionListener {
    private PaymentView paymentView;
    private PaymentViewModel paymentModel;
    private MainController mainController;
    private Database database;
    private Booking booking;


    public PaymentController(Database db, MainController mc, Map<String, Object> args) {
        this.mainController = mc;
        this.database = db;
        this.booking = (Booking) args.get("booking");
        updateModel();

        this.paymentView = new PaymentView(paymentModel);

        // Update the view with model data
        updateView();

        paymentView.addConfirmPaymentListener(this);
    }

    private void updateModel() {
        // Update the paymentModel based on paymentView data
    }
    private void updateView() {
        // Format and set the price breakdown label
        String priceBreakdown = formatPriceBreakdown();
        paymentView.setPriceBreakdown(priceBreakdown);
    }

    private String formatPriceBreakdown() {
        // Format the price breakdown based on paymentModel data
        // Return a string representing the price breakdown
        return "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle confirm payment button click
        // Validate payment data, process payment, etc.
        EmailSender.sendEmail(mainController.getUser().getEmail(), "Payment Confirmation", "Your payment has been confirmed. Here is your ticket information:...\n");
    }

    public PaymentView getView() {
        return paymentView;
    }

}
