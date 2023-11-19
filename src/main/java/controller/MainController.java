package main.java.controller;
import javax.swing.Action;

import main.java.view.ViewMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener{
    private Database db;
    private LoginController loginController;
    private FlightController flightController;
    private ViewMain viewMain;

    public MainController() {
        this.db = Database.getInstance("jdbc:mysql://localhost:3306/airline", "root", "");
        this.flightController = new FlightController(db);
        System.out.println("Welcome to the Airline Reservation System");
        viewMain = new ViewMain();
        viewMain.setVisible(true);
        addListeners();
    }

    public void addListeners() {
        viewMain.addAdmin(this);
        viewMain.addMember(this);
        viewMain.addAgent(this);
        viewMain.addGuest(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String role = e.getActionCommand() ; 
        if (role.equals("Guest")) {
            viewMain.setVisible(false);
            UserController uc = new UserController(db);
        } else {
            viewMain.setVisible(false);
            loginController = new LoginController(db, role);
        }
    }
}
