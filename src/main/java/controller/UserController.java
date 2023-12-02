package controller;

import model.role.*;
import view.UserView;
import java.awt.event.*;

/**
 * Controller class for managing user-related actions in the application.
 */
public class UserController implements ActionListener {
    private User user;
    private UserView userView;
    private Database db;
    private MainController mainController;

    /**
     * Constructs a UserController with the given database and MainController.
     *
     * @param db The database instance to interact with.
     * @param mc The MainController for switching views.
     */
    public UserController(Database db, MainController mc) {
        this.mainController = mc;
        user = mc.getUser();
        this.db = db;
        userView = new UserView(user.getRole());
        updateView();
        addListeners();
    }

    /**
     * Adds action listeners to the UserView components.
     */
    private void addListeners() {
        userView.addBookingsButtonListener(this);
        userView.addLogoutButtonListener(this);
    }

    /**
     * Handles actionPerformed events, typically triggered by button clicks.
     *
     * @param e The ActionEvent object.
     */
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

    /**
     * Updates the user view with the current user's information.
     */
    public void updateView() {
        userView.updateView(user);
    }

    /**
     * Gets the UserView associated with this controller.
     *
     * @return The UserView.
     */
    public UserView getView() {
        return userView;
    }

    /**
     * Gets the current user.
     *
     * @return The User object representing the current user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the current user.
     *
     * @param user The User object to set as the current user.
     */
    public void setUser(User user) {
        this.user = user;
    }
}
