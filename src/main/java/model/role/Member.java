package model.role;

import java.util.ArrayList;
import model.flight.Promotion;

public class Member extends User {
    ArrayList<Promotion> promotions;

    public Member(String username, String password, String email) {
        super(username, password, email);
    }
    // getters and setters

    public ArrayList<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(ArrayList<Promotion> promotions) {
        this.promotions = promotions;
    }

}
