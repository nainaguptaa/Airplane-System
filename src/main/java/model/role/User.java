package model.role;

public class User {
    // mayve add field for access level/role
    private String username;
    private String password;
    private String email;
    private int role;

    public User() {
        this.username = "";
        this.password = "";
        this.email = "";
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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
}
