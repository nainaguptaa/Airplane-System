package main.java.controller;

public class FlightController {
    private Database db;


    public FlightController(Database db) {
        this.db = db;
    }

    public String[][] getAllFlightsd() {
        String[][] flights = db.getAllFlights();
    }
    //include method for returning flights based on search criteria

    //Include method for admin creating flight

    //include method for admin updating flight

    //include method for admin deleting flight


}
