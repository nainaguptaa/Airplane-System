package viewModel;

import model.flight.SeatType;

public class SeatViewModel {
    private String seatID;
    private boolean isAvailable;
    private SeatType seatType;

    public SeatViewModel(String seatID, SeatType type, boolean isAvailable) {
        this.seatID = seatID;
        this.isAvailable = isAvailable;
        this.seatType = type;
    }

    public String getSeatID() {
        return seatID;
    } 

    public boolean getAvailability() {
        return isAvailable;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
