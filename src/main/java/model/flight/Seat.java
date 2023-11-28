package model.flight;

public class Seat {
    private String seatId;
    private int aircraftId;
    private int seatNumber;
    private SeatType seatType;
    private boolean isAvailable;

    public Seat(String seatId, int aircraftId, int seatNumber, SeatType seatType, boolean isAvailable) {
        this.seatId = seatId;
        this.aircraftId = aircraftId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public String getSeatId() {
        return seatId;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}
