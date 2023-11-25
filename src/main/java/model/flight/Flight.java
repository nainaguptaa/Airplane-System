package  model.flight;

public class Flight {
    private int flightId;
    private int aircraftId;
    private String originId;
    private String destinationId;
    private String departureTime; // make time object in utils
    private String arrivalTime;
    private double price;
    private int availableSeats; // make seats an observer strategy, update available seats whenever a seat is
                                // taken

    public Flight() {
        this.flightId = 0;
        this.aircraftId = 0;
        this.originId = "";
        this.destinationId = "";
        this.departureTime = "";
        this.arrivalTime = "";
        this.price = 0;
        this.availableSeats = 0;
    }

    public Flight(int flightId, int aircraftId, String originId, String destinationId, String departureTime,
            String arrivalTime, int price, int availableSeats) {
        this.flightId = flightId;
        this.aircraftId = aircraftId;
        this.originId = originId;
        this.destinationId = destinationId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    // Getters and Setters
    public int getFlightId() {
        return flightId;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public String getOriginId() {
        return originId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
