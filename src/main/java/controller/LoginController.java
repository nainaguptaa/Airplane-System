package main.java.controller;

import main.java.model.role.User;
import main.java.view.LoginView;

public class LoginController {
    private User model;
    private LoginView view;

    public LoginController(User model, LoginView view) {
        this.model = model;
        this.view = view;
    }

    public void setUsername(String username) {
        model.setUsername(username);
    }

    public void setPassword(String password) {
        model.setPassword(password);
    }

    public boolean authenticate(String username, String password) {
        // Here, add your authentication logic
        // For example, checking username and password against stored values
        return model.getUsername().equals(username) && model.getPassword().equals(password);
    }

    public void updateView() {
        view.display();
    }
}
