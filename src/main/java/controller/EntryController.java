package main.java.controller;

import javax.swing.Action;

import main.java.view.EntryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryController implements ActionListener {
    private EntryView viewMain;
    private Database db;
    private MainController mainController;

    public EntryController(Database db, MainController mainController) {
        System.out.println("Welcome to the Airline Reservation System");
        this.db = db;
        this.mainController = mainController;

        viewMain = new EntryView();
        viewMain.setVisible(true);
        addListeners();
    }

    public void addListeners() {
        viewMain.addAdmin(this);
        viewMain.addMember(this);
        viewMain.addAgent(this);
        viewMain.addGuest(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String role = e.getActionCommand();
        mainController.getUser().setRole(getRoleNum(role));
        if (role.equals("Guest")) {
            viewMain.setVisible(false);
            mainController.switchToView("GuestView");
        } else {
            viewMain.setVisible(false);
            mainController.switchToView("LoginView");
        }
    }
}
