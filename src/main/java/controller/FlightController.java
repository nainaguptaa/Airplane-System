package main.java.controller;

public class FlightController {
    private Database db;

    public FlightController(Database db) {
        this.db = db;
    }

    public String[] getAllFlights() {
        return new String[] { "Flight 1", "Flight 2", "Flight 3" };
    }
    // include method for returning flights based on search criteria

    // Include method for admin creating flight

    // include method for admin updating flight

    // include method for admin deleting flight

}
