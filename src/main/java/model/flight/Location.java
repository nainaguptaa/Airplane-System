package  model.flight;

public class Location {
    private int locationId;
    private String city;
    private String state;
    private String country;

    public Location(int locationId, String city, String state, String country) {
        this.locationId = locationId;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // Getters and Setters
    public int getLocationId() {
        return locationId;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
