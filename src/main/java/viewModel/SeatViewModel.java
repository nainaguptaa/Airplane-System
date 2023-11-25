package viewModel;

import model.flight.SeatType;

public class SeatViewModel {
    private int seatID;
    private SeatType seatType;
    private boolean isAvailable;
    private int seatPrice;

    public SeatViewModel(int seatID, SeatType seatType, boolean isAvailable, int seatPrice) {
        this.seatID = seatID;
        this.seatType = seatType;
        this.isAvailable = isAvailable;
        this.seatPrice = seatPrice;
    }
}
