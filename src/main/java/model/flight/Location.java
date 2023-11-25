package  model.flight;

public class Location {
    private String code;
    private String city;
    private String state;
    private String country;

    public Location(String code, String city, String state, String country) {
        this.code = code;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // Getters and Setters
    public String getCode() {
        return code;
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

    public String toString() {
        return code + " (" + city + ", " + state + ", " + country + ")";
    }
}
