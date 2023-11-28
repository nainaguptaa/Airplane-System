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












//good stuff

package view;

import viewModel.PaymentViewModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class PaymentView extends JPanel {
    private JTable PaymentTable;
    private DefaultTableModel tableModel;
    private PaymentViewModel paymentViewModel[];
    private JLabel questionLabel;
    private JButton yesButton;
    private JButton noButton;
    

    // Parameterized constructor
    public PaymentView(PaymentViewModel pvm[]) {
        paymentViewModel = pvm;
        initializeGUI();
    }

    // Default constructor
    public PaymentView() {
         
                PaymentViewModel pvm = new PaymentViewModel(60.00, 800.00, 1.05, true, 10);
                PaymentViewModel pvmArr[] = {pvm};
                paymentViewModel = pvmArr;
                initializeGUI();
                // Add more instances if needed
        
     
    }



    private void initializeGUI() {
        
        setSize(600, 400);
        setLayout(null);

        JLabel lbl = new JLabel("Your Payment Information:");
        lbl.setBounds(250, 20, 200, 30);
        add(lbl);

        // Define column names
        String[] columnNames = {"Seat Price ($)", "Flight Price ($) ", "Tax", "Member", "Promotion (%)"};

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
        scrollPane.setBounds(50, 50, 500, 50);  // Adjust the bounds as needed
        add(scrollPane);

        questionLabel = new JLabel("Would you like to add cancellation insurance ($50) ?");
        questionLabel.setBounds(50, 110, 500, 30);
        add(questionLabel);

        yesButton = new JButton("Yes");
        yesButton.setBounds(50, 150, 80, 30);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your logic for "Yes" button click
                System.out.println("Yes button clicked");
            }
        });
        add(yesButton);

        // Add "No" button
        noButton = new JButton("No");
        noButton.setBounds(140, 150, 80, 30);
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your logic for "No" button click
                System.out.println("No button clicked");
            }
        });
        add(noButton);
    }
    
    
    

    private void loadPaymentInfo() {
        for (PaymentViewModel viewModel : paymentViewModel) {
            tableModel.addRow(new Object[]{viewModel.SeatPrice, viewModel.FlightPrice,
                    viewModel.Tax, viewModel.isMember, viewModel.Promotion});
        }
    }
}



///good stuff






