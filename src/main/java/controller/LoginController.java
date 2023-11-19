package main.java.controller;

import main.java.model.role.User;
import main.java.view.LoginView;
import java.awt.event.*;

import javax.swing.Action;

//Will need to add listener when login view is created
public class LoginController implements ActionListener{
    private User model;
    private LoginView view;
    private Database db;
    private LoginView loginView;
    private UserController uc;

    public LoginController(Database db, String role) {
        this.model = new User();
        model.setRole(getRoleNum(role));
        this.view = new LoginView();
        this.db = db;
        view.setVisible(true);
        addListeners();
    }

    private int getRoleNum(String role) {
        if (role.equals("Admin")) {
            return 4;
        } else if (role.equals("Agent")) {
            return 3;
        } else if (role.equals("Member")) {
            return 2;
        } else {
            return 1;
        }
    }

    private void addListeners(){
        loginView.addLoginListener(this);
        loginView.addRegisterListener(this);
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

    public boolean authenticate() {
        String query = "SELECT * FROM user WHERE username = '" + model.getUsername() + "' AND password = '" + model.getPassword() + "' AND role <= " + model.getRole();
        return db.executeQuery(query) != null;
    }

    public void login() {
        if (authenticate()) {
            updateView();
            this.uc = new UserController(db);
            this.uc.setUser(model);
        } else {
            System.out.println("Invalid username or password");
        }
    }

    public void logout() {
        setUsername("");
        setPassword("");
        updateView();
    }

    public void register() {
        // check if user already exists
        String query = "SELECT * FROM user WHERE username = '" + model.getUsername() + "'";
        if (db.executeQuery(query) != null) {
            System.out.println("User already exists");
        } else {
            // insert user into database
            try{
                query = "INSERT INTO user (username, password, email) VALUES ('" + model.getUsername() + "', '"
                        + model.getPassword() + "', '" + model.getEmail() + "')";
                db.executeUpdate(query);
            } catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            this.uc = new UserController(db);
            this.uc.setUser(model);
            System.out.println("User registered successfully");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action: " + e.getActionCommand());
        setPassword(loginView.getPassword());
        setUsername(loginView.getUsername());
        //setEmail(loginView.getEmail()); //might not receive email from login view, will need to check
        try{
            if (e.getActionCommand().equals("login")) {
                login();
            }  else if (e.getActionCommand().equals("register")) { //probably will need to change this
                register();
            }
        } catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void updateView() {
        view.display();
    }
}
