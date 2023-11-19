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

    @Override
    public void actionPerformed(ActionEvent e) {
        String role = e.getActionCommand();
        if (role.equals("Guest")) {
            viewMain.setVisible(false);
            mainController.switchToView("GuestView");
        } else {
            viewMain.setVisible(false);
            mainController.switchToLoginView(role);
        }
    }
}
