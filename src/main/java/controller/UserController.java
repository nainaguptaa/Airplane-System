package controller;

import model.role.*;

public class UserController {
    private User user;
    private Database db;
    private MainController mainController;

    public UserController(Database db, MainController mc) {
        this.mainController = mc;
        this.db = db;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // maybe add methods for different types of users (admin, member, etc.)
}
