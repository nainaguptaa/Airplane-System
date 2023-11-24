package model.flight;

public class Booking {
    private int bookingId;
    private String username;
    private int flightId;
    private int seatId;
    private double price;
    private String bookingTime; //Make time object
    private String insurance;

    public Booking(int bookingId, int flightId, String username, int seatId,  String insurance, double price, String bookingTime) {
        this.bookingId = bookingId;
        this.username = username;
        this.flightId = flightId;
        this.seatId = seatId;
        this.price = price;
        this.bookingTime = bookingTime;
        this.insurance = insurance;
    }

    public String[] getBookingData() {
        String[] data = new String[5];
        data[0] = "Flight ID: " + flightId;
        data[1] = "Seat ID: " + seatId;
        data[2] = "Insurance: " + insurance;
        data[3] = "Price: " + price;
        data[4] = "Booking Time: " + bookingTime;
        return data;
    }

    // Getters and Setters

    public int getBookingId() {
        return bookingId;
    }

    public String getUsername() {
        return username;
    }

    public int getFlightId() {
        return flightId;
    }

    public int getSeatId() {
        return seatId;
    }

    public double getPrice() {
        return price;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }
}   
