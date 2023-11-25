package model.flight;

public class Booking {
    private int bookingId;
    private int userId;
    private int flightId;
    private int seatId;
    private int price;
    private String bookingTime; // Make time object

    public Booking(int bookingId, int userId, int flightId, int seatId, int price, String bookingTime) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.flightId = flightId;
        this.seatId = seatId;
        this.price = price;
        this.bookingTime = bookingTime;
    }

    // Getters and Setters

    public int getBookingId() {
        return bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public int getSeatId() {
        return seatId;
    }

    public int getPrice() {
        return price;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
