package model.role;


public class Crew extends User{
    private int flighId;
    private int userId;
    private int crewId;

    public Crew(int flightId, int userId, int crewId, String username, String password, String email) {
        super(username, password, email);
        this.flighId = flightId;
        this.userId = userId;
        this.crewId = crewId;
    }
}
