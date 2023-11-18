package main.java.model.role;

import main.java.utils.Address;

public class Member extends User {
    private String prefEmail;
    private String name;
    private Address address;

    public Member(String username, String password, String name, Address address) {
        super(username, password);
        this.name = name;
        this.address = address;

        // Add code in here so when a user registers and member object is created, the
        // information is stored in the database right away.
    }

    // getters and setters
    public String getMemberEmail() {
        return prefEmail;
    }

    public String getMemberName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setMemberEmail(String newEmail) {
        this.prefEmail = newEmail;
    }

    public void setMemberName(String newName) {
        this.name = newName;
    }

}
