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
  private String SeatTypeVal;
  private double SeatPrice;
  private double totalPrice;


  public PaymentController(Database db, MainController mc, Booking booking) {
    this.mainController = mc;
    this.booking = booking;
    this.view = new PaymentView();
    this.db = db;
    addListeners();
}


int seatId = booking.getSeatId();
double flight_price = booking.getPrice();





// public string seatType() {
//   String query = "SELECT class FROM seats WHERE seat_id = '" + booking.getSeatId() +  "'"; 
//   ResultSet rs = db.executeQuery(query);
//   try {
//       return rs.next();
//   } catch (Exception e) { }
// }

public void seatType() {
  String query = "SELECT class FROM seats WHERE seat_id = '" + booking.getSeatId() + "'";
  ResultSet rs = db.executeQuery(query);

  try {
      if (rs.next()) {
          SeatTypeVal = rs.getString("class");
      } 
  } catch (SQLException e) {
      e.printStackTrace(); // Handle or log the exception appropriately
      // Or throw an exception if needed
  } finally {
      // Close resources in a finally block
      try {
          if (rs != null) {
              rs.close();
          }
          // Close other resources if needed (e.g., preparedStatement)
      } catch (SQLException e) {
          e.printStackTrace(); // Handle or log the exception appropriately
      }
  }
}

public double seatPrice() {
  if ("business".equals(SeatTypeVal)) {
      SeatPrice = 50.00;
  }
  if ("comfort".equals(SeatTypeVal)) {
      SeatPrice = 35.00;
  }
  if ("ordinary".equals(SeatTypeVal)) {
      SeatPrice = 20.00;
  }
  return SeatPrice;
}



public void Promotion() {
  String query = "SELECT discount FROM promototion WHERE seat_id = '" + booking.getSeatId() + "'";
  ResultSet rs = db.executeQuery(query);

  try {
      if (rs.next()) {
          SeatTypeVal = rs.getString("class");
      } 
  } catch (SQLException e) {
      e.printStackTrace(); // Handle or log the exception appropriately
      // Or throw an exception if needed
  } finally {
      // Close resources in a finally block
      try {
          if (rs != null) {
              rs.close();
          }
          // Close other resources if needed (e.g., preparedStatement)
      } catch (SQLException e) {
          e.printStackTrace(); // Handle or log the exception appropriately
      }
  }
}

public double ifPromotion() {
  double flight_price = booking.getPrice();
  double above_price = 300.00;
  double NewtotalPrice;
  totalPrice = flight_price + SeatPrice;

  if (totalPrice >= above_price) {
      // Fetch a randomized discount value from the promotion table
      double discount = getRandomDiscount();
      
      // Apply the discount to the totalPrice
      NewtotalPrice = totalPrice - (totalPrice * discount);

      return NewtotalPrice;
  } else {
      // If the promotion condition is not met, return the original totalPrice
      return totalPrice;
  }
}


private double getRandomDiscount() {
  String query = "SELECT discount FROM promotion ORDER BY RAND() LIMIT 1";
  try {
      ResultSet rs = db.executeQuery(query);
      if (rs.next()) {
          return rs.getDouble("discount");
      }
  } catch (SQLException e) {
      e.printStackTrace(); // Handle or log the exception appropriately
  }

  // Return a default discount value if fetching from the table fails
  return 0.0;
}



public PaymentView getView() {
  return view;
}

private void addListeners() {
  view.addConfirmListener(this);
}



}