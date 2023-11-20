
package main.java.controller;

import main.java.model.role.User;

import javax.swing.*;
import java.awt.*;

public class MainController {
    private Database db;
    private static MainController instance;
    private EntryController entryController;
    private LoginController loginController;
    private UserController userController;
    private RegisterController registerController;
    private User user;
    private FlightController flightController;

    private JFrame mainFrame;

    private MainController() {
        this.db = Database.getInstance("jdbc:mysql://localhost:3306/airline", "root", "SagittariusA5290$");

        mainFrame = new JFrame("Airline Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600); // Set a default size or pack after adding components
        mainFrame.setLayout(new BorderLayout());

        this.user = new User();
        this.switchToView("EntryView");
        mainFrame.setVisible(true);
    }

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void switchToView(String viewName) {
        mainFrame.getContentPane().removeAll(); // Remove existing view components

        switch (viewName) {
            case "EntryView":
                entryController = new EntryController(db, this);
                mainFrame.getContentPane().add(entryController.getView());
                break;

            case "FlightView":
                flightController = new FlightController(db, this);
                mainFrame.getContentPane().add(flightController.getView());
                break;

            case "LoginView":
                loginController = new LoginController(db, this);
                mainFrame.getContentPane().add(loginController.getView());
                break;

            case "RegisterView":
                registerController = new RegisterController(db, this);
                mainFrame.getContentPane().add(registerController.getView());
                break;

            default:
                break;
        }

        mainFrame.getContentPane().revalidate();
        mainFrame.getContentPane().repaint();
    }
}
