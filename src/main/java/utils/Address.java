package main.java.utils;

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

public class Address {
    private String street;
    private String city;
    private String division;
    private int code;
    private Direction direction;
    private String postalCode;
    private String country;

    // Constructor
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

    // Getters and Setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getdivision() {
        return division;
    }

    public void setdivision(String division) {
        this.division = division;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
