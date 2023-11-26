package  model.flight;

public enum SeatType {
    ORDINARY, 
    COMFORT, 
    BUSINESS;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public static SeatType fromString(String str) {
        try{
            return SeatType.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
