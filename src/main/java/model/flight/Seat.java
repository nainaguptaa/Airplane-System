package model.flight;

/**
 * Represents a seat on an aircraft with various attributes including a unique seat ID,
 * aircraft ID, seat number, seat type, and availability status.
 */
public class Seat {
    private String seatId;
    private int aircraftId;
    private int seatNumber;
    private SeatType seatType;
    private boolean isAvailable;

    /**
     * Constructs a Seat object with the provided attributes.
     *
     * @param seatId     The unique identifier for the seat.
     * @param aircraftId The ID of the aircraft to which the seat belongs.
     * @param seatNumber The seat number or identifier.
     * @param seatType   The type of the seat (e.g., first class, economy).
     * @param isAvailable Whether the seat is available (true) or booked (false).
     */
    public Seat(String seatId, int aircraftId, int seatNumber, SeatType seatType, boolean isAvailable) {
        this.seatId = seatId;
        this.aircraftId = aircraftId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters

    /**
     * Gets the unique seat ID.
     *
     * @return The seat ID.
     */
    public String getSeatId() {
        return seatId;
    }

    /**
     * Gets the ID of the aircraft to which the seat belongs.
     *
     * @return The aircraft ID.
     */
    public int getAircraftId() {
        return aircraftId;
    }

    /**
     * Gets the seat number or identifier.
     *
     * @return The seat number.
     */
    public int getSeatNumber() {
        return seatNumber;
    }

    /**
     * Gets the type of the seat (e.g., first class, economy).
     *
     * @return The seat type.
     */
    public SeatType getSeatType() {
        return seatType;
    }

    /**
     * Checks whether the seat is available.
     *
     * @return True if the seat is available; false if it is booked.
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Sets the unique seat ID.
     *
     * @param seatId The seat ID to set.
     */
    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    /**
     * Sets the ID of the aircraft to which the seat belongs.
     *
     * @param aircraftId The aircraft ID to set.
     */
    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    /**
     * Sets the seat number or identifier.
     *
     * @param seatNumber The seat number to set.
     */
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * Sets the type of the seat (e.g., first class, economy).
     *
     * @param seatType The seat type to set.
     */
    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    /**
     * Sets the availability status of the seat.
     *
     * @param isAvailable True if the seat is available; false if it is booked.
     */
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
