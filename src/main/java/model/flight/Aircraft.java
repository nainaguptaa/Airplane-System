package  model.flight;

import java.util.ArrayList;

public class Aircraft {
    private ArrayList<Seat> seats;
    private int id;
    private String model;
    private int capacity;

    public Aircraft() {
        this.seats = new ArrayList<Seat>();
    }

    public Aircraft(int id, String model, int capacity) {
        this.id = id;
        this.model = model;
        this.capacity = capacity;
        this.seats = new ArrayList<Seat>();
    }

    // Getters and Setters
    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }

    public void removeSeat(Seat seat) {
        this.seats.remove(seat);
    }

    public void setAircraftID(int id) {
        this.id = id;
    }

    public int getAircraftID() {
        return this.id;
    }

}
