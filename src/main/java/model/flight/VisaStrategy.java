package main.java.model.flight;

public class VisaStrategy implements PaymentStrategy {


  @Override
  public void pay(int amount){
    System.out.println("Exectuing Visa Payment: Charging $" + amount);
  }

}