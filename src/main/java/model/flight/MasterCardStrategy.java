package main.java.model.flight;
 
 

public class MasterCardStrategy implements PaymentStrategy{

  @Override
  public void pay(int amount) {
      System.out.println("Executing MasterCard payment: Charging $ " + amount);
  }
  
}


