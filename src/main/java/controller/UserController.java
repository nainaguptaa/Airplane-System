package main.java.controller;

import main.java.model.role.*;

public class UserController {
    private User user;
    private Database db;

    public UserController(Database db) {
        this.db = db;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    //maybe add methods for different types of users (admin, member, etc.)
}
