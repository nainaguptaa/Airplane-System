package main.java.model.flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PaymentContext {
  private final PaymentStrategy paymentStrategy;
  private final int flightId;  
  private final Connection databaseConnection;
  // private final int amount;
  private final boolean hasCancellationInsurance;


  public PaymentContext(int flightId, PaymentStrategy paymentStrategy, Connection databaseConnection, boolean hasCancellationInsurance) {
    this.flightId = flightId;
    this.paymentStrategy = paymentStrategy;
    this.databaseConnection = databaseConnection;
    this.hasCancellationInsurance = hasCancellationInsurance;
}

public void processPayment() {
  // Retrieve flight price from the database
  int flightPrice = getFlightPriceFromDatabase(flightId);

  // Add cancellation insurance if selected
  if (hasCancellationInsurance) {
      flightPrice += 50; // $50 for cancellation insurance
  }

  // Pass the total amount to the payment strategy
  paymentStrategy.pay(flightPrice);
}


private int getFlightPriceFromDatabase(int flightId) {
  try {
    String query = "SELECT price FROM flights WHERE flight_id = ?";
    try (PreparedStatement preparedStatement = databaseConnection.prepareStatement(query)) {
      preparedStatement.setInt(1, flightId);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          return resultSet.getInt("price");
        }
      }
    }
  } catch (SQLException e) {
    // Handle database errors
    e.printStackTrace();
  }

  // Return a default price or handle the absence of the flight
  return 0;
}



}