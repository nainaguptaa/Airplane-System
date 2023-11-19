package main.java.model.role;

import java.util.Date;
import main.java.model.util.CreditCard;

import main.java.utils.Address;

public class Member extends User {
    private String name;
    private Address address;

    public Member(String username, String password, String name, Address address) {
        super(username, password);
        this.name = name;
        this.address = address;

        // Add code in here so when a user registers and member object is created, the
        // information is stored in the database right away.
    }

    public Member(String username, String password, String name, String email, int addrCode, String addrStreet,
            String addrDirection, CreditCard card) {
        super(username, password, email);
        this.name = name;
        this.addrCode = addrCode;
        this.addrDirection = addrDirection;
        this.addrStreet = addrStreet;
        this.card = card;

        // Add code in here so when a user registers and member object is created, the
        // information is stored in the database right away.
    }

    // getters and setters

    public String getMemberName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setMemberName(String newName) {
        this.name = newName;
    }

}
