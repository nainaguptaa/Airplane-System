package main.java.controller;

import main.java.model.role.*;
import main.java.view.UserView;

public class UserController {
    private User user;
    private UserView userView;
    private Database db;
    private MainController mainController;

    public UserController(Database db, MainController mc) {
        this.mainController = mc;
        user = mc.getUser();
        this.db = db;
        userView = new UserView();
    }

    public void updateView() {
        userView.updateView(user);
    }

    public UserView getView() {
        return userView;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    // maybe add methods for different types of users (admin, member, etc.)
}
