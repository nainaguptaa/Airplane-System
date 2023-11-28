package viewModel;

import model.flight.SeatType;

public class SeatViewModel {
    private int seatID;
    private boolean isAvailable;
    private SeatType seatType;
    private String seatNumber;

    public SeatViewModel(int seatID, SeatType type, boolean isAvailable, String seatNumber) {
        this.seatID = seatID;
        this.isAvailable = isAvailable;
        this.seatType = type;
        this.seatNumber = seatNumber;
    }

    public int getSeatID() {
        return seatID;
    } 

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
