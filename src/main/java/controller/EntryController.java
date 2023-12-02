package controller;

import javax.swing.Action;

import view.EntryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.role.User;
import java.util.Map;

/**
 * The EntryController class manages user interactions with the entry view,
 * allowing users to select their role and navigate to different views accordingly.
 */
public class EntryController implements ActionListener {
    private EntryView entryView;
    private Database db;
    private MainController mainController;

    /**
     * Constructs an EntryController.
     *
     * @param db              The database instance for user authentication and data retrieval.
     * @param mainController  The main controller for managing views and navigation.
     */
    public EntryController(Database db, MainController mainController) {
        this.db = db;
        this.mainController = mainController;
        mainController.removeNavPanel();
        entryView = new EntryView();
        addListeners();
    }

    /**
     * Adds action listeners to the role selection buttons in the entry view.
     */
    public void addListeners() {
        entryView.addAdmin(this);
        entryView.addMember(this);
        entryView.addAgent(this);
        entryView.addGuest(this);
    }

    /**
     * Handles user actions when a role selection button is clicked.
     *
     * @param e The ActionEvent representing the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String role = e.getActionCommand();
        mainController.getUser().setRole(User.roleToInt(role));
        if (role.equals("Guest")) {
            mainController.switchToView("FlightView");
            mainController.createNavPanel();
        } else {
            mainController.switchToView("LoginView");
        }
    }

    /**
     * Gets the EntryView associated with this controller.
     *
     * @return The EntryView instance.
     */
    public EntryView getView() {
        return entryView;
    }
}
