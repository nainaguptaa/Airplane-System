package model.flight;

public enum SeatType {
    ORDINARY,
    COMFORT,
    BUSINESS;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public static SeatType fromString(String str) {
        try {
            return SeatType.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static int getPriceByType(SeatType type) {
        if (type == null) {
            throw new IllegalArgumentException("Seat type cannot be null");
        }

        switch (type) {
            case BUSINESS:
                return 50;
            case COMFORT:
                return 35;
            case ORDINARY:
                return 20;
            default:
                throw new IllegalArgumentException("Unknown seat type: " + type);
        }
    }
}
