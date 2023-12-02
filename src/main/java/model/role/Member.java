package model.role;

import java.util.ArrayList;
import model.flight.Promotion;

/**
 * Represents a member, extending the User class, with an additional attribute for storing promotions.
 */
public class Member extends User {
    ArrayList<Promotion> promotions;

    /**
     * Constructs a Member object with the provided username, password, and email.
     *
     * @param username The username of the member's user account.
     * @param password The password of the member's user account.
     * @param email    The email address of the member's user account.
     */
    public Member(String username, String password, String email) {
        super(username, password, email);
    }

    // Getters and Setters

    /**
     * Gets the list of promotions associated with the member.
     *
     * @return The list of promotions.
     */
    public ArrayList<Promotion> getPromotions() {
        return promotions;
    }

    /**
     * Sets the list of promotions associated with the member.
     *
     * @param promotions The list of promotions to set.
     */
    public void setPromotions(ArrayList<Promotion> promotions) {
        this.promotions = promotions;
    }
}
