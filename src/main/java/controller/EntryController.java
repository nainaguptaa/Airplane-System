package main.java.controller;

import javax.swing.Action;

import main.java.view.EntryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        if (role.equals("Guest")) {
            // entryView.setVisible(false);
            mainController.switchToView("GuestView");
        } else {
            // entryView.setVisible(false);
            mainController.switchToView("LoginView");
        }
    }

    public EntryView getView() {
        return entryView;
    }
}
