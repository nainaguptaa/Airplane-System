package model.flight;

public class Seat {
    private int seatId;
    private int aircraftId;
    private int seatNumber;
    private SeatType seatType;
    private boolean isAvailable;

    public Seat(int seatId, int aircraftId, int seatNumber, SeatType seatType, boolean isAvailable) {
        this.seatId = seatId;
        this.aircraftId = aircraftId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public int getSeatId() {
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

    public void setSeatId(int seatId) {
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
