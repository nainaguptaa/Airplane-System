package view;

import ViewModel.PaymentViewModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentView extends JPanel {
    private JTable PaymentTable;
    private DefaultTableModel tableModel;
    private PaymentViewModel paymentViewModel;
    private JLabel questionLabel;
    private JButton yesButton;
    private JButton noButton;
    private double cancellation;
    private double total;
    private double PriceBeforeTax;
    private double finalPrice;
    private JTextArea breakdownTextArea;
    private JLabel breakdownLabel;
    private JLabel cardInfoLabel;
    private JTextField cardNumber;
    private JTextField expirationDate;
    private JTextField cvv;
    private JLabel cardNumberLabel;
    private JLabel expirationDateLabel;
    private JLabel cvvLabel;
    private JButton confirmButton;

    // Parameterized constructor
    public PaymentView(PaymentViewModel pvm) {
        paymentViewModel = pvm;
        cancellation = 0.00;
        initializeGUI();
        displayTotal();
    }

    private void initializeGUI() {

        breakdownLabel = new JLabel("Price Breakdown:");
        breakdownLabel.setBounds(50, 200, 150, 20);
        breakdownLabel.setVisible(false);
        add(breakdownLabel);

        breakdownTextArea = new JTextArea();
        breakdownTextArea.setEditable(false);
        breakdownTextArea.setBounds(50, 220, 500, 150);
        breakdownTextArea.setVisible(false);
        add(breakdownTextArea);

        cardInfoLabel = new JLabel("Please enter Credit card information:");
        cardInfoLabel.setBounds(50, 400, 250, 20);
        add(cardInfoLabel);

        cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(50, 430, 200, 20);
        add(cardNumberLabel);

        cardNumber = new JTextField();
        cardNumber.setBounds(160, 430, 200, 20);
        add(cardNumber);

        expirationDateLabel = new JLabel("Expiration Date:");
        expirationDateLabel.setBounds(50, 460, 200, 20);
        add(expirationDateLabel);

        expirationDate = new JTextField();
        expirationDate.setBounds(160, 460, 200, 20);
        add(expirationDate);

        cvvLabel = new JLabel("CVV:");
        cvvLabel.setBounds(50, 490, 200, 20);
        add(cvvLabel);

        cvv = new JTextField();
        cvv.setBounds(160, 490, 200, 20);
        add(cvv);

        confirmButton = new JButton("Confirm Payment");
        confirmButton.setBounds(400, 500, 200, 50);

        add(confirmButton);

        setSize(600, 1200);
        setLayout(null);

        JLabel lbl = new JLabel("Your Payment Information:");
        lbl.setBounds(250, 20, 200, 30);
        add(lbl);

        // Define column names
        String[] columnNames = { "Seat Price ($)", "Flight Price ($) ", "Tax", "Member", "Promotion (%)" };

        // Initialize the table model and set column names
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Load payment info
        loadPaymentInfo();

        PaymentTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(PaymentTable);
        scrollPane.setBounds(50, 50, 500, 50);
        add(scrollPane);

        questionLabel = new JLabel("Would you like to add cancellation insurance ($50) ?");
        questionLabel.setBounds(50, 110, 500, 30);
        add(questionLabel);

        yesButton = new JButton("Yes");
        yesButton.setBounds(50, 150, 80, 30);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cancellation = 50.00;
                displayTotal();
            }
        });
        add(yesButton);

        noButton = new JButton("No");
        noButton.setBounds(140, 150, 80, 30);
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancellation = 0.00;
                displayTotal();
            }
        });
        add(noButton);
    }

    public double getCancellation() {
        return cancellation;
    }

    public void addConfirmPaymentListener(ActionListener listener) {
        confirmButton.addActionListener(listener);
    }

    public void displayTotal() {
        boolean isMember = paymentViewModel.getIsMember();
        double seatPrice = paymentViewModel.getSeatPrice();
        double flightPrice = paymentViewModel.getFlightPrice();
        double tax = paymentViewModel.getTax();
        double promotion = isMember ? paymentViewModel.getPromotionDiscount() : 0.0;

        total = seatPrice + flightPrice + cancellation;
        PriceBeforeTax = total - (total * (promotion / 100));
        finalPrice = PriceBeforeTax + tax;

        String breakdown = "Seat Price: $" + seatPrice + "\n" +
                "Flight Price: $" + flightPrice + "\n" +
                "Cancellation Fee: $" + cancellation + "\n" +
                "Discount: " + promotion + "%" +
                "\nTax: " + tax + "\n" +
                "---------------------------\n" +
                "Total: $" + finalPrice;

        breakdownTextArea.setText(breakdown);
        breakdownLabel.setVisible(true);
        breakdownTextArea.setVisible(true);
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    // Checks if all three fields are filled
    public boolean validateCardInfo() {
        return !cardNumber.getText().isEmpty() && !expirationDate.getText().isEmpty() && !cvv.getText().isEmpty();
    }

    private void loadPaymentInfo() {
        tableModel.addRow(new Object[] { paymentViewModel.getSeatPrice(), paymentViewModel.getFlightPrice(),
                paymentViewModel.getTax(), paymentViewModel.getIsMember(), paymentViewModel.getPromotionDiscount() });
    }
}
