package model.flight;

/**
 * Represents a location with a unique code, city, state, and country.
 */
public class Location {
    private String code;
    private String city;
    private String state;
    private String country;

    /**
     * Constructs a Location object with the provided attributes.
     *
     * @param code    The unique code associated with the location.
     * @param city    The city where the location is situated.
     * @param state   The state or region where the location is located.
     * @param country The country where the location is situated.
     */
    public Location(String code, String city, String state, String country) {
        this.code = code;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // Getters and Setters

    /**
     * Gets the unique code associated with the location.
     *
     * @return The location code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the city where the location is situated.
     *
     * @return The city name.
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the state or region where the location is located.
     *
     * @return The state or region name.
     */
    public String getState() {
        return state;
    }

    /**
     * Gets the country where the location is situated.
     *
     * @return The country name.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Returns a string representation of the Location object.
     *
     * @return A string in the format: "code (city, state, country)".
     */
    public String toString() {
        return code + " (" + city + ", " + state + ", " + country + ")";
    }
}
