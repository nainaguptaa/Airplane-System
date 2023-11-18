package main.java.model.role;

public class Member extends User {
    private String prefEmail;
    private String name;
    private int addrCode;
    private String addrStreet;
    private String addrDirection; // Northwest, Southeast, etc.

    /*
     * I feel like we should put all the address information into its own object
     * kind of how he discussed in class
     * because an address would be separated into multiple pieces of information not
     * just the ones I listed above
     * (postal code, city, province/state) I'm just not sure where we would put an
     * "Address" class. The code will look cleaner.
     */

    public Member(String username, String password, String name, int addrCode, String addrStreet,
            String addrDirection) {
        super(username, password);
        this.name = name;
        this.addrCode = addrCode;
        this.addrDirection = addrDirection;
        this.addrStreet = addrStreet;

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

    public int getAddrCode() {
        return addrCode;
    }

    public String getAddrStreet() {
        return addrStreet;
    }

    public String getAddrDirection() {
        return addrDirection;
    }

    public void setMemberEmail(String newEmail) {
        this.prefEmail = newEmail;
    }

    public void setMemberName(String newName) {
        this.name = newName;
    }

    public void setAddrCode(int newCode) {
        this.addrCode = newCode;
    }

    public void setAddrStreet(String newStreet) {
        this.addrStreet = newStreet;
    }

    public void setAddrDirection(String newDirection) {
        this.addrDirection = newDirection;
    }
}
