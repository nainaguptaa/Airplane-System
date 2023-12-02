package view;

import ViewModel.PaymentViewModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The PaymentView class represents the view for handling payment and displaying payment information.
 */
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

    /**
     * Constructs a new PaymentView with a PaymentViewModel.
     *
     * @param pvm The PaymentViewModel containing payment information.
     */
    public PaymentView(PaymentViewModel pvm) {
        paymentViewModel = pvm;
        cancellation = 0.00;
        initializeGUI();
        displayTotal();
    }

    private void initializeGUI() {
        // Create and configure UI components
        
        
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

        
        // Set the layout to null for manual component positioning
        setLayout(null);

        // Define column names for the payment table
        String[] columnNames = { "Seat Price ($)", "Flight Price ($) ", "Tax", "Member", "Promotion (%)" };

        // Initialize the table model and set column names
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Load payment info into the table
        loadPaymentInfo();

        // Create a JTable with the configured table model
        PaymentTable = new JTable(tableModel);

        // Create a scroll pane to display the payment table
        JScrollPane scrollPane = new JScrollPane(PaymentTable);
        scrollPane.setBounds(50, 50, 500, 50);
        add(scrollPane);

        // Display a question label for cancellation insurance
        questionLabel = new JLabel("Would you like to add cancellation insurance ($50) ?");
        questionLabel.setBounds(50, 110, 500, 30);
        add(questionLabel);

        // Create and configure "Yes" button for adding cancellation insurance
        yesButton = new JButton("Yes");
        yesButton.setBounds(50, 150, 80, 30);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // User chose to add cancellation insurance
                cancellation = 50.00;
                displayTotal();
            }
        });
        add(yesButton);

        // Create and configure "No" button for not adding cancellation insurance
        noButton = new JButton("No");
        noButton.setBounds(140, 150, 80, 30);
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // User chose not to add cancellation insurance
                cancellation = 0.00;
                displayTotal();
            }
        });
        add(noButton);
    }

    /**
     * Gets the cancellation fee.
     *
     * @return The cancellation fee.
     */
    public double getCancellation() {
        return cancellation;
    }

    /**
     * Adds an ActionListener to the "Confirm Payment" button.
     *
     * @param listener The ActionListener to be added.
     */
    public void addConfirmPaymentListener(ActionListener listener) {
        confirmButton.addActionListener(listener);
    }

    /**
     * Displays the total payment information including seat price, flight price, tax, and discounts.
     */
    public void displayTotal() {
        // Check if the customer is a member
        boolean isMember = paymentViewModel.getIsMember();
        
        // Get various pricing components from the PaymentViewModel
        double seatPrice = paymentViewModel.getSeatPrice();
        double flightPrice = paymentViewModel.getFlightPrice();
        double tax = paymentViewModel.getTax();
        
        // Determine the promotion discount based on membership status
        double promotion = isMember ? paymentViewModel.getPromotionDiscount() : 0.0;

        // Calculate the total cost including seat price, flight price, and cancellation fee
        total = seatPrice + flightPrice + cancellation;
        
        // Calculate the price before tax considering the promotion discount
        PriceBeforeTax = total - (total * (promotion / 100));
        
        // Calculate the final price including tax
        finalPrice = PriceBeforeTax + tax;

        // Create a breakdown string to display the pricing details
        String breakdown = "Seat Price: $" + seatPrice + "\n" +
                "Flight Price: $" + flightPrice + "\n" +
                "Cancellation Fee: $" + cancellation + "\n" +
                "Discount: " + promotion + "%" +
                "\nTax: " + tax + "\n" +
                "---------------------------\n" +
                "Total: $" + finalPrice;

        // Set the breakdown text in the JTextArea
        breakdownTextArea.setText(breakdown);
        breakdownLabel.setVisible(true);
        breakdownTextArea.setVisible(true);
    }

    /**
     * Gets the final payment price.
     *
     * @return The final payment price.
     */
    public double getFinalPrice() {
        return finalPrice;
    }

    /**
     * Validates card information by checking if all required fields are filled.
     *
     * @return true if card information is valid; false otherwise.
     */
    public boolean validateCardInfo() {
        return !cardNumber.getText().isEmpty() && !expirationDate.getText().isEmpty() && !cvv.getText().isEmpty();
    }

    /**
     * Loads payment information into the payment table.
     */
    private void loadPaymentInfo() {
        // Add a row to the table containing seat price, flight price, tax, membership status, and promotion discount
        tableModel.addRow(new Object[] { paymentViewModel.getSeatPrice(), paymentViewModel.getFlightPrice(),
                paymentViewModel.getTax(), paymentViewModel.getIsMember(), paymentViewModel.getPromotionDiscount() });
    }

}
