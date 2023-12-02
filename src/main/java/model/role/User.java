package model.role;

import java.util.ArrayList;
import model.flight.Booking;

/**
 * Represents a user with various attributes such as username, password, email, role, membership status,
 * first name, last name, address, and a list of bookings.
 */
public class User {
    private String username;
    private String password;
    private String email;
    private int role;
    private Boolean member;
    private String firstName;
    private String lastName;
    private String address;
    private ArrayList<Booking> bookings;

    /**
     * Default constructor for a User object with initial values.
     */
    public User() {
        this.username = "";
        this.password = "";
        this.email = "";
        this.role = 1;
        this.member = false;
        this.firstName = "";
        this.lastName = "";
    }

    /**
     * Constructs a User object with the provided username, password, and email.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @param email    The email address of the user.
     */
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.member = false;
    }

    // Getters and Setters

    /**
     * Gets the username of the user.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the role of the user as an integer.
     *
     * @return The role as an integer.
     */
    public int getRole() {
        return role;
    }

    /**
     * Sets the role of the user as an integer.
     *
     * @param role The role to set as an integer.
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * Gets the membership status of the user.
     *
     * @return The membership status.
     */
    public Boolean getMember() {
        return member;
    }

    /**
     * Sets the membership status of the user.
     *
     * @param member The membership status to set.
     */
    public void setMember(Boolean member) {
        this.member = member;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the address of the user.
     *
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the user.
     *
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the list of bookings associated with the user.
     *
     * @return The list of bookings.
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     * Sets the list of bookings associated with the user.
     *
     * @param bookings The list of bookings to set.
     */
    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     * Converts a numeric role value to its corresponding string representation.
     *
     * @param role The numeric role value.
     * @return The string representation of the role.
     */
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

    /**
     * Converts a string representation of a role to its corresponding numeric value.
     *
     * @param role The string representation of the role.
     * @return The numeric role value.
     */
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
}
