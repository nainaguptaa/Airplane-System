package controller;

import model.role.User;
import view.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Controller class for user registration.
 */
public class RegisterController implements ActionListener {
    private User model;
    private RegisterView view;
    private Database db;
    private MainController mainController;

    /**
     * Constructs a RegisterController with the given database and MainController.
     *
     * @param db The database instance to interact with.
     * @param mc The MainController for switching views.
     */
    public RegisterController(Database db, MainController mc) {
        this.mainController = mc;
        this.model = mainController.getUser();
        this.view = new RegisterView();
        this.db = db;
        addListeners();
    }

    /**
     * Gets the RegisterView associated with this controller.
     *
     * @return The RegisterView.
     */
    public RegisterView getView() {
        return view;
    }

    /**
     * Adds action listeners to the RegisterView components.
     */
    private void addListeners() {
        view.addCancelListener(this);
        view.addRegisterListener(this);
    }

    /**
     * Sets the username in the User model.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        model.setUsername(username);
    }

    /**
     * Sets the password in the User model.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        model.setPassword(password);
    }

    /**
     * Sets the email in the User model.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        model.setEmail(email);
    }

    /**
     * Sets the first name in the User model.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        model.setFirstName(firstName);
    }

    /**
     * Sets the last name in the User model.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        model.setLastName(lastName);
    }

    /**
     * Sets the address in the User model.
     *
     * @param address The address to set.
     */
    public void setAddress(String address) {
        model.setAddress(address);
    }

    /**
     * Sets the role in the User model.
     *
     * @param role The role to set.
     */
    public void setRole(int role) {
        model.setRole(role);
    }

    /**
     * Handles the user registration process.
     */
    public void register() {
        // Check if any fields are null
        String username = model.getUsername();
        String password = model.getPassword();
        String email = model.getEmail();
        String firstName = model.getFirstName();
        String lastName = model.getLastName();
        String address = model.getAddress();

        if (username.equals("") || password.equals("") || email.equals("") || firstName.equals("") || lastName.equals("")
                || address.equals("")) {
            view.addError("Please fill out all fields");
            return;
        }

        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        ResultSet rs = db.executeQuery(query);

        try {
            if (rs != null) {
                if (rs.next()) {
                    System.out.println("User already exists"); // Maybe make this an exception
                } else {
                    // Insert user into the database
                    try {
                        query = "INSERT INTO users (username, password, first_name, last_name, address, email, role) VALUES ('"
                                + username + "', '"
                                + password + "', '" + firstName + "', '" + lastName + "', '" + address + "', '" + email + "', '" + 2 + "')";
                        System.out.println(query);
                        db.executeUpdate(query);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println("User registered successfully");
                    mainController.switchToView("UserView");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setPassword(view.getPassword());
        setUsername(view.getUsername());
        setEmail(view.getEmail());
        setFirstName(view.getFirstName());
        setLastName(view.getLastName());
        setAddress(view.getAddress());
        setRole(2);

        try {
            if (e.getActionCommand().equals("Register")) {
                register();
            }
            if (e.getActionCommand().equals("Cancel")) {
                mainController.switchToView("EntryView");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
