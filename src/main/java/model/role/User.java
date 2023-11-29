package model.role;

import java.util.ArrayList;
import model.flight.Booking;


public class User {
    // mayve add field for access level/role
    private String username;
    private String password;
    private String email;
    private int role;
    private Boolean member;
    private String firstName;
    private String lastName;
    private String address;
    private ArrayList<Booking> bookings;

    public User() {
        this.username = "";
        this.password = "";
        this.email = "";
        this.role = 1;
        this.member = false;
        this.firstName = "";
        this.lastName = "";

    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.member = false;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setMember(Boolean member) {
        this.member = member;
    }

    public Boolean getMember() {
        return member;
    }

    public static String roleToString(int role) {
        if (role == 4) {
            return "Admin";
        } else if (role == 3) {
            return "Agent";
        } else if (role == 2) {
            return "User";
        } else if (role == 1) {
            return "Guest";
        } else {
            return "Invalid Role";
        }
    }

    public static int roleToInt(String role) {
        if (role.equals("Admin")) {
            return 4;
        } else if (role.equals("Agent")) {
            return 3;
        } else if (role.equals("User")) {
            return 2;
        } else if (role.equals("Guest")) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }
}
