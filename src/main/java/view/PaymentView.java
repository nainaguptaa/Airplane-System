// package main.java.view;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class PaymentView extends JFrame {

//     private JRadioButton yesRadioButton;
//     private JRadioButton noRadioButton;
//     public PaymentView() {
//         setTitle("Payment Page");
//         setSize(1200, 800);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
//         panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


//         JLabel question = new JLabel("Would you like to add cancellation insurance ($50)?");
//         question.setHorizontalAlignment(SwingConstants.CENTER);
//         yesRadioButton = new JRadioButton("Yes");
//         noRadioButton = new JRadioButton("No");

//         ButtonGroup group = new ButtonGroup();
//         group.add(yesRadioButton);
//         group.add(noRadioButton);

//         JLabel questionLabel = new JLabel("Please select a payment method.");
//         questionLabel.setHorizontalAlignment(SwingConstants.CENTER);

//         JButton MasterCardButton = new JButton("MasterCard");
//         MasterCardButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 showMasterCardDialog();
                
//             }
//         });

//         JButton VisaButton = new JButton("Visa");
//         VisaButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//               showVisaDialog();
//             }
//         });

//         panel.add(question);
//         panel.add(yesRadioButton);
//         panel.add(noRadioButton);
//         panel.add(questionLabel);
//         panel.add(new JLabel()); 
//         panel.add(MasterCardButton);
//         panel.add(new JLabel()); 
//         panel.add(VisaButton);

//         add(panel);
//     }

//     private void showMasterCardDialog() {
//         JTextField cardNumberField = new JTextField();
//         JTextField expiryField = new JTextField();
//         JTextField cvvField = new JTextField();
//         JTextField firstName = new JTextField();
//         JTextField lastName = new JTextField();

//         Object[] message = {
//                 "First Name:", firstName,
//                 "Last Name:", lastName,
//                 "Card Number:", cardNumberField,
//                 "Expiry Date:", expiryField,
//                 "CVV:", cvvField
//         };

//         int option = JOptionPane.showOptionDialog(
//                 this,
//                 message,
//                 "Enter  MasterCard Information",
//                 JOptionPane.OK_CANCEL_OPTION,
//                 JOptionPane.PLAIN_MESSAGE,
//                 null,
//                 new Object[]{"Confirm Payment", "Cancel Payment"},
//                 "Confirm Payment"
//         );

//         if (option == JOptionPane.OK_OPTION) {
//             String cardNumber = cardNumberField.getText();
//             String expiryDate = expiryField.getText();
//             String cvv = cvvField.getText();
//             processMasterCardPayment(cardNumber, expiryDate, cvv);
//         } else {
//             System.out.println("Payment canceled.");
//         }
//     }

//     private void processMasterCardPayment(String cardNumber, String expiryDate, String cvv) {
//         // Implement credit card payment processing logic
//         System.out.println("Processing Master Card payment...");
//         System.out.println("Card Number: " + cardNumber);
//         System.out.println("Expiry Date: " + expiryDate);
//         System.out.println("CVV: " + cvv);
//     }







//     private void showVisaDialog() {
//       JTextField cardNumberField = new JTextField();
//       JTextField expiryField = new JTextField();
//       JTextField cvvField = new JTextField();
//       JTextField firstName = new JTextField();
//       JTextField lastName = new JTextField();

//       Object[] message = {
//               "First Name:", firstName,
//               "Last Name:", lastName,
//               "Card Number:", cardNumberField,
//               "Expiry Date:", expiryField,
//               "CVV:", cvvField
//       };

//       int option = JOptionPane.showOptionDialog(
//               this,
//               message,
//               "Enter Visa Card Information",
//               JOptionPane.OK_CANCEL_OPTION,
//               JOptionPane.PLAIN_MESSAGE,
//               null,
//               new Object[]{"Confirm Payment", "Cancel Payment"},
//               "Confirm Payment"
//       );

//       if (option == JOptionPane.OK_OPTION) {
//           String cardNumber = cardNumberField.getText();
//           String expiryDate = expiryField.getText();
//           String cvv = cvvField.getText();
//           processVisaPayment(cardNumber, expiryDate, cvv);
//       } else {
//           System.out.println("Payment canceled.");
//       }
//   }

//   private void processVisaPayment(String cardNumber, String expiryDate, String cvv) {
//       // Implement credit card payment processing logic
//       System.out.println("Processing Visa Card payment...");
//       System.out.println("Card Number: " + cardNumber);
//       System.out.println("Expiry Date: " + expiryDate);
//       System.out.println("CVV: " + cvv);
//   }

//   public boolean hasCancellationInsurance() {
//     return yesRadioButton.isSelected();
// }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new PaymentView().setVisible(true));
//     }
// }





package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Setup Decorator Pattern
public class PaymentView extends JPanel {
    private JTextField cardNumber;
    private JTextField expirationDate;
    private JTextField cvv;
    private JButton confirmBtn;
    private JButton yesButton;
    private JLabel messageLabel; // Label to display messages

    public PaymentView() {
        // setTitle("Login");
        setSize(450, 300);
        setBackground(new Color(230, 230, 250));

        // Using BorderLayout for overall layout
        setLayout(new BorderLayout(10, 10));
        add(createFormPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
        add(createMessagePanel(), BorderLayout.NORTH); // Add message panel at the top
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4); // Padding

        // Username
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Card Number:"), gbc);
        cardNumber = new JTextField(10);
        gbc.gridx = 1;
        formPanel.add(cardNumber, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Expiration Date:"), gbc);
        expirationDate = new JTextField(10);
        gbc.gridx = 1;
        formPanel.add(expirationDate, gbc);

                // Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("CVV:"), gbc);
        cvv = new JTextField(10);
        gbc.gridx = 1;
        formPanel.add(cvv, gbc);

            // Cancellation Insurance Message
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Would you like cancellation insurance?"), gbc);

        return formPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Login Button
        confirmBtn = new JButton("Confirm Booking");
        buttonPanel.add(confirmBtn);

        
        JButton yesButton = new JButton("Yes");
        buttonPanel.add(yesButton);

        return buttonPanel;
    }

    private JPanel createMessagePanel() {
        JPanel messagePanel = new JPanel();
        messageLabel = new JLabel(" ");
        messagePanel.add(messageLabel);
        return messagePanel;
    }


    public JButton getYesButton() {
        return yesButton;
    }


    public void addConfirmListener(ActionListener al) {
        confirmBtn.addActionListener(al);
    }



    public void display() {
        System.out.println("Payment Page:");
        // Code to display login form (username and password fields)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PaymentView());
    }
}