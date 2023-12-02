package model.flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Represents a flight with various attributes such as flight ID, aircraft ID, origin, destination,
 * departure and arrival times, price, and available seats.
 */
public class Flight {
    private int flightId;
    private int aircraftId;
    private String originId;
    private String destinationId;
    private Date departureTime;
    private Date arrivalTime;
    private double price;
    private int availableSeats;

    /**
     * Constructs an empty Flight object with default values.
     */
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

    /**
     * Constructs a Flight object with the provided attributes.
     *
     * @param flightId       The unique identifier for the flight.
     * @param aircraftId     The ID of the aircraft associated with the flight.
     * @param originId       The ID of the origin location.
     * @param destinationId  The ID of the destination location.
     * @param departureTime  The departure time of the flight.
     * @param arrivalTime    The arrival time of the flight.
     * @param price          The price of the flight.
     * @param availableSeats The number of available seats on the flight.
     */
    public Flight(int flightId, int aircraftId, String originId, String destinationId, Date departureTime,
                  Date arrivalTime, double price, int availableSeats) {
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

    /**
     * Gets the flight ID.
     *
     * @return The unique identifier for the flight.
     */
    public int getFlightId() {
        return flightId;
    }

    /**
     * Gets the aircraft ID associated with the flight.
     *
     * @return The ID of the aircraft.
     */
    public int getAircraftId() {
        return aircraftId;
    }

    /**
     * Gets the origin location ID.
     *
     * @return The ID of the origin location.
     */
    public String getOriginId() {
        return originId;
    }

    /**
     * Gets the destination location ID.
     *
     * @return The ID of the destination location.
     */
    public String getDestinationId() {
        return destinationId;
    }

    /**
     * Gets the departure time of the flight as a Date object.
     *
     * @return The departure time.
     */
    public Date getDepartureTime() {
        return departureTime;
    }

    /**
     * Gets the arrival time of the flight as a Date object.
     *
     * @return The arrival time.
     */
    public Date getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Gets the formatted departure time as a string (yyyy-MM-dd HH:mm:ss).
     *
     * @return The formatted departure time.
     */
    public String getDepartureString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(departureTime);
    }

    /**
     * Gets the formatted arrival time as a string (yyyy-MM-dd HH:mm:ss).
     *
     * @return The formatted arrival time.
     */
    public String getArrivalString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(arrivalTime);
    }

    /**
     * Gets the departure time as a LocalDateTime object.
     *
     * @return The departure time as LocalDateTime.
     */
    public LocalDateTime getDepartureLocalDateTime() {
        return LocalDateTime.ofInstant(departureTime.toInstant(), ZoneId.systemDefault());
    }

    /**
     * Gets the arrival time as a LocalDateTime object.
     *
     * @return The arrival time as LocalDateTime.
     */
    public LocalDateTime getArrivalLocalDateTime() {
        return LocalDateTime.ofInstant(arrivalTime.toInstant(), ZoneId.systemDefault());
    }

    /**
     * Gets the price of the flight.
     *
     * @return The price of the flight.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the number of available seats on the flight.
     *
     * @return The available seats count.
     */
    public int getAvailableSeats() {
        return availableSeats;
    }

    /**
     * Sets the flight ID.
     *
     * @param flightId The unique identifier for the flight.
     */
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    /**
     * Sets the aircraft ID associated with the flight.
     *
     * @param aircraftId The ID of the aircraft.
     */
    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    /**
     * Sets the origin location ID.
     *
     * @param originId The ID of the origin location.
     */
    public void setOriginId(String originId) {
        this.originId = originId;
    }

    /**
     * Sets the destination location ID.
     *
     * @param destinationId The ID of the destination location.
     */
    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    /**
     * Sets the departure time of the flight.
     *
     * @param departureTime The departure time.
     */
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Sets the arrival time of the flight.
     *
     * @param arrivalTime The arrival time.
     */
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Sets the price of the flight.
     *
     * @param price The price of the flight.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the number of available seats on the flight.
     *
     * @param availableSeats The available seats count.
     */
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

}
   
