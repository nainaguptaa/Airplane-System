package main.java.controller;

import javax.swing.Action;

import main.java.view.EntryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.model.role.User;

public class EntryController implements ActionListener {
    private EntryView entryView;
    private Database db;
    private MainController mainController;

    public EntryController(Database db, MainController mainController) {
        System.out.println("Welcome to the Airline Reservation System");
        this.db = db;
        this.mainController = mainController;
        entryView = new EntryView();
        addListeners();
    }

    public void addListeners() {
        entryView.addAdmin(this);
        entryView.addMember(this);
        entryView.addAgent(this);
        entryView.addGuest(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String role = e.getActionCommand();
        mainController.getUser().setRole(User.roleToInt(role));
        if (role.equals("Guest")) {
            mainController.switchToView("GuestView");
        } else {
            mainController.switchToView("LoginView");
        }
    }

    public EntryView getView() {
        return entryView;
    }
}
