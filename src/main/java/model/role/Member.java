package model.role;

import java.util.Date;
import model.util.CreditCard;
import model.util.Address;

public class Member extends User {
    private String name;
    private Address address;

    public Member(String username, String password, String email, String name, Address address) {
        super(username, password, email);
        this.name = name;
        this.address = address;
    }
    // getters and setters

    public String getMemberName() {
        return name;
    }

    // public Address getAddress() {
    //     return address;
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
