package model.flight;

import java.util.ArrayList;

/**
 * Represents an Aircraft with a list of seats, an ID, a model, and a capacity.
 */
public class Aircraft {
    private ArrayList<Seat> seats;
    private int id;
    private String model;
    private int capacity;

    /**
     * Constructs an empty Aircraft object with no seats.
     */
    public Aircraft() {
        this.seats = new ArrayList<Seat>();
    }

    /**
     * Constructs an Aircraft object with the specified ID, model, and capacity.
     *
     * @param id       The unique identifier for the aircraft.
     * @param model    The model of the aircraft.
     * @param capacity The maximum passenger capacity of the aircraft.
     */
    public Aircraft(int id, String model, int capacity) {
        this.id = id;
        this.model = model;
        this.capacity = capacity;
        this.seats = new ArrayList<Seat>();
    }

    // Getters and Setters

    /**
     * Gets the list of seats associated with this aircraft.
     *
     * @return An ArrayList of Seat objects.
     */
    public ArrayList<Seat> getSeats() {
        return seats;
    }

    /**
     * Sets the list of seats associated with this aircraft.
     *
     * @param seats An ArrayList of Seat objects.
     */
    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    /**
     * Adds a seat to the list of seats associated with this aircraft.
     *
     * @param seat The Seat object to add.
     */
    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }

    /**
     * Removes a seat from the list of seats associated with this aircraft.
     *
     * @param seat The Seat object to remove.
     */
    public void removeSeat(Seat seat) {
        this.seats.remove(seat);
    }

    /**
     * Sets the ID of the aircraft.
     *
     * @param id The unique identifier for the aircraft.
     */
    public void setAircraftID(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the aircraft.
     *
     * @return The unique identifier for the aircraft.
     */
    public int getAircraftID() {
        return this.id;
    }
}
