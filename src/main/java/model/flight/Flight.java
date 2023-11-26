package model.flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Flight {
    private int flightId;
    private int aircraftId;
    private String originId;
    private String destinationId;
    private Date departureTime; // make time object in utils
    private Date arrivalTime;
    private double price;
    private int availableSeats; // make seats an observer strategy, update available seats whenever a seat is
                                // taken

    public Flight() {
        this.flightId = 0;
        this.aircraftId = 0;
        this.originId = "";
        this.destinationId = "";
        this.departureTime = null;
        this.arrivalTime = null;
        this.price = 0;
        this.availableSeats = 0;
    }

    public Flight(int flightId, int aircraftId, String originId, String destinationId, Date departureTime,
            Date arrivalTime, int price, int availableSeats) {
        this.flightId = flightId;
        this.aircraftId = aircraftId;
        this.originId = originId;
        this.destinationId = destinationId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    // Getters and Setters
    public int getFlightId() {
        return flightId;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public String getOriginId() {
        return originId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(departureTime);
    }

    public String getArrivalString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(arrivalTime);
    }

    public LocalDateTime getDepartureLocalDateTime() {
        return LocalDateTime.ofInstant(departureTime.toInstant(), ZoneId.systemDefault());
    }

    public LocalDateTime getArrivalLocalDateTime() {
        return LocalDateTime.ofInstant(arrivalTime.toInstant(), ZoneId.systemDefault());
    }
    

    public double getPrice() {
        return price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
