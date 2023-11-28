package view;

import ViewModel.PaymentViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PaymentView extends JPanel {
    private JLabel priceBreakdownLabel;
    private JTextField paymentDataField;
    private JCheckBox insuranceCheckBox;
    private JButton confirmPaymentButton;
    private PaymentViewModel paymentModel;
    public PaymentView(PaymentViewModel paymentModel) {
        setLayout(new BorderLayout());
        this.paymentModel = paymentModel;

        // Price breakdown label
        priceBreakdownLabel = new JLabel();
        add(priceBreakdownLabel, BorderLayout.NORTH);

        // Payment data form
        JPanel formPanel = new JPanel(new GridLayout(0, 1));
        paymentDataField = new JTextField();
        formPanel.add(new JLabel("Payment Information:"));
        formPanel.add(paymentDataField);

        // Insurance check box
        insuranceCheckBox = new JCheckBox("Cancellation Insurance");
        formPanel.add(insuranceCheckBox);

        // Confirm payment button
        confirmPaymentButton = new JButton("Confirm Payment");
        formPanel.add(confirmPaymentButton);

        add(formPanel, BorderLayout.CENTER);
    }

    public void setPriceBreakdown(String text) {
        priceBreakdownLabel.setText(text);
    }

    public void addConfirmPaymentListener(ActionListener listener) {
        confirmPaymentButton.addActionListener(listener);
    }

    public JCheckBox getInsuranceCheckBox() {
        return insuranceCheckBox;
    }
}
