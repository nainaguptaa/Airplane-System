// package main.java.controller;
// import main.java.model.flight.PaymentContext;
// import main.java.model.flight.PaymentStrategy;
// import main.java.model.flight.MasterCardStrategy;
// import main.java.model.flight.VisaStrategy;
// import main.java.view.PaymentView;
// import java.sql.Connection;

// public class PaymentController {
//   private final PaymentView paymentView;
//   private final Connection databaseConnection;

//   public PaymentController(PaymentView paymentView, Connection databaseConnection) {
//       this.paymentView = paymentView;
//       this.databaseConnection = databaseConnection;
//       initialize();
//   }

//   private void initialize() {
//     // Add listeners for user actions in the PaymentView
//     paymentView.getMasterCardButton().addActionListener(e -> processPayment("MasterCard"));
//     paymentView.getVisaButton().addActionListener(e -> processPayment("Visa"));
//     // Add listeners for other UI components as needed
// }

// private void processPayment(String paymentMethod) {
//   // Get relevant information from the View
//   int flightId = /* get flightId */;
//   boolean hasCancellationInsurance = paymentView.hasCancellationInsurance();

//   // Create a PaymentStrategy based on the payment method
//   PaymentStrategy paymentStrategy;

//   switch (paymentMethod) {
//       case "MasterCard":
//           paymentStrategy = new MasterCardStrategy();
//           break;
//       case "Visa":
//           paymentStrategy = new VisaStrategy();
//           break;
//   }
// }

// PaymentContext paymentContext = new PaymentContext(flightId, paymentStrategy, databaseConnection, hasCancellationInsurance);
// paymentContext.processPayment(paymentMethod);

// }




package main.java.controller;
import main.java.model.role.User;
import main.java.model.flight.Booking;
import main.java.view.PaymentView;
import java.awt.event.*;

import javax.swing.Action;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PaymentController implements ActionListener{
  private Booking booking;
  private Database db;
  private PaymentView view;
  private MainController mainController;


  public PaymentController(Database db, MainController mc, Booking booking) {
    this.mainController = mc;
    this.booking = booking;
    this.view = new PaymentView();
    this.db = db;
}

public PaymentView getView() {
  return view;
}





}