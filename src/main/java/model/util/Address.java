package model.util;

/**
 * An enumeration representing cardinal directions.
 */
enum Direction {
    NORTHWEST, NORTHEAST, SOUTHWEST, SOUTHEAST;

    @Override
    public String toString() {
        switch (this) {
            case NORTHWEST:
                return "Northwest";
            case NORTHEAST:
                return "Northeast";
            case SOUTHWEST:
                return "Southwest";
            case SOUTHEAST:
                return "Southeast";
            default:
                throw new IllegalArgumentException();
        }
    }
}

/**
 * Represents an address with various attributes such as street, city, division, postal code, country, etc.
 */
public class Address {
    private String street;
    private String city;
    private String division;
    private int code;
    private Direction direction;
    private String postalCode;
    private String country;

    /**
     * Constructs an Address object with the provided details.
     *
     * @param code       The code of the address.
     * @param street     The street address.
     * @param direction  The cardinal direction (e.g., Northwest, Northeast).
     * @param city       The city name.
     * @param division   The division or state.
     * @param postalCode The postal code.
     * @param country    The country name.
     */
    public Address(int code, String street, Direction direction, String city, String division, String postalCode,
                   String country) {
        this.street = street;
        this.city = city;
        this.division = division;
        this.code = code;
        this.direction = direction;
        this.postalCode = postalCode;
        this.country = country;
    }

    /**
     * Constructs an Address object by parsing a comma-separated address string.
     *
     * @param address The comma-separated address string.
     */
    public Address(String address) {
        String[] parts = address.split(",");
        this.street = parts[0];
        this.city = parts[1];
        this.division = parts[2];
        this.code = Integer.parseInt(parts[3]);
        this.direction = Direction.valueOf(parts[4]);
        this.postalCode = parts[5];
        this.country = parts[6];
    }

    // Getters and Setters

    /**
     * Gets the street address.
     *
     * @return The street address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address.
     *
     * @param street The street address to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the city name.
     *
     * @return The city name.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city name.
     *
     * @param city The city name to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the code of the address.
     *
     * @return The code of the address.
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the code of the address.
     *
     * @param code The code to set.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets the cardinal direction (e.g., Northwest, Northeast).
     *
     * @return The cardinal direction.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Sets the cardinal direction.
     *
     * @param direction The cardinal direction to set.
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Gets the division or state.
     *
     * @return The division or state.
     */
    public String getDivision() {
        return division;
    }

    /**
     * Sets the division or state.
     *
     * @param division The division or state to set.
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * Gets the postal code.
     *
     * @return The postal code.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code.
     *
     * @param postalCode The postal code to set.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets the country name.
     *
     * @return The country name.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country name.
     *
     * @param country The country name to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
