package model.role;

/**
 * Represents a crew member, extending the User class, with additional attributes
 * specific to crew members, such as flight ID, user ID, and crew ID.
 */
public class Crew extends User {
    private int flightId;
    private int userId;
    private int crewId;

    /**
     * Constructs a Crew object with the provided attributes, including flight ID, user ID, crew ID,
     * username, password, and email.
     *
     * @param flightId The ID of the flight associated with the crew member.
     * @param userId   The unique identifier for the crew member's user account.
     * @param crewId   The unique identifier for the crew member.
     * @param username The username of the crew member's user account.
     * @param password The password of the crew member's user account.
     * @param email    The email address of the crew member's user account.
     */
    public Crew(int flightId, int userId, int crewId, String username, String password, String email) {
        super(username, password, email);
        this.flightId = flightId;
        this.userId = userId;
        this.crewId = crewId;
    }

    // Getters and Setters

    /**
     * Gets the flight ID associated with the crew member.
     *
     * @return The flight ID.
     */
    public int getFlightId() {
        return flightId;
    }

    /**
     * Gets the user ID of the crew member.
     *
     * @return The user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Gets the crew ID of the crew member.
     *
     * @return The crew ID.
     */
    public int getCrewId() {
        return crewId;
    }

    /**
     * Sets the flight ID associated with the crew member.
     *
     * @param flightId The flight ID to set.
     */
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    /**
     * Sets the user ID of the crew member.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Sets the crew ID of the crew member.
     *
     * @param crewId The crew ID to set.
     */
    public void setCrewId(int crewId) {
        this.crewId = crewId;
    }
}
