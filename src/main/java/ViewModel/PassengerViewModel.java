package ViewModel;

public class PassengerViewModel {
    private String username;
    private String firstName;
    private String lastName;
    private String seat;
    private int seatId;

    public PassengerViewModel(String username, int seatId, String seatNumber) {
        this.username = username;
        this.seatId = seatId;
        this.seat = seatNumber;
    }

    public String getUserName() {
        return username;
    }

    public int getSeatID() {
        return seatId;
    }

    public String getSeat() {
        return seat;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }
}
