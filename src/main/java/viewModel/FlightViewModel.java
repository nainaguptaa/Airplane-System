package viewModel;

public class FlightViewModel {
    public String Destination;
    public String Departure;
    public String DepartureTime;
    public String ArrivalTime;
    public int Price;
    public String FlightNumber;
    public int FlightId;

    public FlightViewModel(int FlightId, String Destination, String Departure, String DepartureTime, String ArrivalTime, int Price,
            String FlightNumber) {
        this.FlightId = FlightId;
        this.Destination = Destination;
        this.Departure = Departure;
        this.DepartureTime = DepartureTime;
        this.ArrivalTime = ArrivalTime;
        this.Price = Price;
        this.FlightNumber = FlightNumber;
    }

}
