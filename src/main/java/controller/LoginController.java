package controller;

import model.role.User;
import view.LoginView;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;

/**
 * The LoginController class manages user interactions with the login view, 
 * including authentication and switching to other views.
 */
public class LoginController implements ActionListener {
    private User model;
    private LoginView view;
    private Database db;
    private MainController mainController;

    /**
     * Constructs a LoginController.
     *
     * @param db The database instance for data retrieval.
     * @param mc The main controller for managing views and navigation.
     */
    public LoginController(Database db, MainController mc) {
        this.mainController = mc;
        this.model = mainController.getUser();
        this.view = new LoginView();
        if (model.getRole() == 2) {
            view.addRegisterButton();
        }
        this.db = db;
        addListeners();
    }

    /**
     * Gets the LoginView associated with this controller.
     *
     * @return The LoginView instance.
     */
    public LoginView getView() {
        return view;
    }

    /**
     * Adds action listeners to the login view components.
     */
    private void addListeners() {
        view.addLoginListener(this);
        view.addRegisterListener(this);
        view.addBackListener(this);
    }

    /**
     * Sets the username in the user model.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        model.setUsername(username);
    }

    /**
     * Sets the password in the user model.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        model.setPassword(password);
    }

    /**
     * Sets the email in the user model.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        model.setEmail(email);
    }

    /**
     * Authenticates the user with the provided username and password.
     *
     * @return True if authentication is successful; false otherwise.
     */
    public boolean authenticate() {
        String query = "SELECT * FROM users WHERE username = '" + model.getUsername() + "' AND password = '"
                + model.getPassword() + "' AND role >= " + model.getRole();
        ResultSet rs = db.executeQuery(query);
        try {
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Performs the login action.
     * If authentication is successful, switches to the UserView and creates the navigation panel.
     * Otherwise, displays an error message.
     */
    public void login() {
        if (authenticate()) {
            System.out.println("Login successful");
            getAndSetUserInfo();
            mainController.switchToView("UserView");
            mainController.createNavPanel();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
            System.out.println("Invalid username or password");
        }
    }

    /**
     * Retrieves user information from the database and sets it in the user model.
     */
    public void getAndSetUserInfo() {
        String query = "SELECT * FROM users WHERE username = '" + model.getUsername() + "' AND password = '"
                + model.getPassword() + "' AND role >= " + model.getRole();
        ResultSet rs = db.executeQuery(query);
        try {
            if (rs.next()) {
                model.setUsername(rs.getString("username"));
                model.setPassword(rs.getString("password"));
                model.setEmail(rs.getString("email"));
                model.setMember(rs.getBoolean("member"));
                model.setFirstName(rs.getString("first_name"));
                model.setLastName(rs.getString("last_name"));
                model.setAddress(rs.getString("address"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Handles user actions based on the event.
     *
     * @param e The ActionEvent representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action: " + e.getActionCommand());
        try {
            if (e.getActionCommand().equals("Login")) {
                setPassword(view.getPassword());
                setUsername(view.getUsername());
                login();
            } else if (e.getActionCommand().equals("Register")) {
                mainController.switchToView("RegisterView");
            } else if (e.getActionCommand().equals("Back")) {
                mainController.switchToView("EntryView");
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
