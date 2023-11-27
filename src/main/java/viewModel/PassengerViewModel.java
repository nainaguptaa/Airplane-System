package viewModel;

public class PassengerViewModel {
    private String username;
    private String firstName;
    private String lastName;
    private String seat;
    private int seatId;

    public PassengerViewModel(String username, String fName, String lName, String seat) {
        this.username = username;
        this.firstName = fName;
        this.lastName = lName;
        this.seat = seat;
    }

    public PassengerViewModel(String username, int seatId) {
        this.username = username;
        this.seatId = seatId;
    }

    public String getUserName() {
        return username;
    }

    public int getSeatID() {
        return seatId;
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
