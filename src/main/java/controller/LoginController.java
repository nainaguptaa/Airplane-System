package controller;

import model.role.User;
import view.LoginView;
import java.awt.event.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.Action;
import java.sql.ResultSet;

//Will need to add listener when login view is created
public class LoginController implements ActionListener {
    private User model;
    private LoginView view;
    private Database db;
    private MainController mainController;

    public LoginController(Database db, MainController mc) {
        this.mainController = mc;
        this.model = mainController.getUser();
        this.view = new LoginView();
        this.db = db;
        addListeners();
    }

    public LoginView getView() {
        return view;
    }

    private void addListeners() {
        view.addLoginListener(this);
        view.addRegisterListener(this);
        view.addBackListener(this);
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
        String query = "SELECT * FROM users WHERE username = '" + model.getUsername() + "' AND password = '"
                + model.getPassword() + "' AND role >= " + model.getRole();
        ResultSet rs = db.executeQuery(query);
        try {
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    public void login() {
        if (authenticate()) {
            System.out.println("Login successful");
            getAndSetUserInfo();
            mainController.switchToView("UserView");
            mainController.createNavPanel();
            // this.uc = new UserController(db);
            // this.uc.setUser(model);
        } else {
            System.out.println("Invalid username or password");
        }
    }

    public void logout() {
        setUsername("");
        setPassword("");
        updateView();
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action: " + e.getActionCommand());
        try {
            if (e.getActionCommand().equals("Login")) {
                setPassword(view.getPassword());
                setUsername(view.getUsername());
                login();
            } else if (e.getActionCommand().equals("Register")) { // probably will need to change this
                mainController.switchToView("RegisterView");
            } else if (e.getActionCommand().equals("Back")) {
                mainController.switchToView("EntryView");
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void updateView() {
        view.display();
    }
}
