package model.role;

import java.util.Date;
import model.util.CreditCard;
import model.util.Address;

public class Member extends User {
    private String name;
    private Address address;
    private CreditCard card;

    public Member(String username, String password, String email, String name, Address address, CreditCard card) {
        super(username, password, email);
        this.name = name;
        this.address = address;
        this.card = card;

        // Add code in here so when a user registers and member object is created, the
        // information is stored in the database right away.
    }
    // getters and setters

    public String getMemberName() {
        return name;
    }

    // public Address getAddress() {
    // return address;
    // }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setMemberName(String newName) {
        this.name = newName;
    }

    public CreditCard getCreditCard() {
        return card;
    }

    public void setCreditCard(CreditCard card) {
        this.card = card;
    }

}
