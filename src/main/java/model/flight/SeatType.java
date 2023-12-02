package model.flight;

/**
 * Enumeration representing different types of seats, including ORDINARY, COMFORT, and BUSINESS.
 */
public enum SeatType {
    ORDINARY,
    COMFORT,
    BUSINESS;

    /**
     * Returns a lowercase string representation of the seat type.
     *
     * @return The lowercase string representation of the seat type.
     */
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    /**
     * Converts a string to a SeatType enum value. The input string is case-insensitive.
     *
     * @param str The string representation of the seat type.
     * @return The corresponding SeatType enum value, or null if the string does not match any valid seat type.
     */
    public static SeatType fromString(String str) {
        try {
            return SeatType.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * Returns the price associated with a specific seat type.
     *
     * @param type The string representation of the seat type.
     * @return The price for the specified seat type.
     * @throws IllegalArgumentException if the input type is null or an unknown seat type.
     */
    public static int getPriceByType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Seat type cannot be null");
        }

        switch (type.toUpperCase()) {
            case "BUSINESS":
                return 50;
            case "COMFORT":
                return 35;
            case "ORDINARY":
                return 20;
            default:
                throw new IllegalArgumentException("Unknown seat type: " + type);
        }
    }
}
