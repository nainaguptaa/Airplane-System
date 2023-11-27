package controller;

import model.role.User;
import view.RegisterView;
import java.awt.event.*;

import javax.swing.Action;
import java.sql.ResultSet;
import java.sql.SQLException;

//Will need to add listener when login view is created
public class RegisterController implements ActionListener {
    private User model;
    private RegisterView view;
    private Database db;
    private MainController mainController;

    public RegisterController(Database db, MainController mc) {
        this.mainController = mc;
        this.model = mainController.getUser();
        this.view = new RegisterView();
        this.db = db;
        addListeners();
    }

    public RegisterView getView() {
        return view;
    }

    private void addListeners() {
        view.addCancelListener(this);
        view.addRegisterListener(this);
    }

    public void setUsername(String username) {
        model.setUsername(username);
    }

    public void setPassword(String password) {
        model.setPassword(password);
    }

    public void setEmail(String email) {
        model.setEmail(email);
    }

    public void setFirstName(String firstName) {
        model.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        model.setLastName(lastName);
    }

    public void setAddress(String address) {
        model.setAddress(address);
    }

    public void setRole(int role) {
        model.setRole(role);
    }

    public void register() {
        // check if user already exists
        String username = model.getUsername();
        String password = model.getPassword();
        String email = model.getEmail();
        String firstName = model.getFirstName();
        String lastName = model.getLastName();
        String address = model.getAddress();

        // check if any fields null
        if (username.equals("") || password.equals("") || email.equals("") || firstName.equals("") || lastName.equals("")
                || address.equals("")) {
            view.addError("Please fill out all fields");
            return;
        }

        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        ResultSet rs = db.executeQuery(query);

        // check if query was null or returned nothing
        try {
            if (rs != null) {
                if (rs.next()) {
                    System.out.println("User already exists"); // Maybe make this an exception
                } else {
                    // insert user into database
                    try {
                        query = "INSERT INTO users (username, password, first_name, last_name, address, email, role) VALUES ('" + username
                                + "', '"
                                + password + "', '" + firstName + "', '" + lastName + "', '" + address + "', '" + email + "', '" + 2 + "')";
                        System.out.println(query);
                        db.executeUpdate(query);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    // this.uc = new UserController(db);
                    // this.uc.setUser(model);
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
            if (e.getActionCommand().equals("Register")) { // probably will need to change this
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
