package controller;

import model.role.*;
import model.role.*;
import view.UserView;
import java.awt.event.*;

public class UserController implements ActionListener {
    private User user;
    private UserView userView;
    private Database db;
    private MainController mainController;

    public UserController(Database db, MainController mc) {
        this.mainController = mc;
        user = mc.getUser();
        this.db = db;
        userView = new UserView(user.getRole());
        updateView();
        addListeners();
    }

    private void addListeners() {
        userView.addBookingsButtonListener(this);
        userView.addLogoutButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("BookingsView")) {
            mainController.switchToView("BookingsView");
        } else if (e.getActionCommand().equals("Logout")) {
            mainController.switchToView("EntryView");
            mainController.setUser(new User());
            mainController.removeNavPanel();
        }
    }

    public void updateView() {
        userView.updateView(user);
    }

    public UserView getView() {
        return userView;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // maybe add methods for different types of users (admin, member, etc.)
}
