package main.java.controller;
import main.java.view.ViewMain;

public class MainController {
    private Database db;
    private LoginController loginController;
    private FlightController flightController;

    public MainController() {
        this.db = Database.getInstance("jdbc:mysql://localhost:3306/airline", "root", "");
        this.flightController = new FlightController(db);
        System.out.println("Welcome to the Airline Reservation System");
        ViewMain viewMain = new ViewMain();
        viewMain.setVisible(true);
    }
}
