package viewModel;

import model.flight.SeatType;

public class SeatViewModel {
    private String seatID;
    private SeatType seatType;
    private boolean isAvailable;
    private int seatPrice;

    public SeatViewModel(String seatID, SeatType seatType, boolean isAvailable, int seatPrice) {
        this.seatID = seatID;
        this.seatType = seatType;
        this.isAvailable = isAvailable;
        this.seatPrice = seatPrice;
    }
}
