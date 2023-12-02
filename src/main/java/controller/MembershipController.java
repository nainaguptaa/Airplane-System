package controller;

import view.MembershipView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.role.User;

import javax.swing.*;

/**
 * Controller class for managing user memberships.
 */
public class MembershipController implements ActionListener {

    private MembershipView view;
    private Database db;
    private MainController mainController;
    private User user;

    /**
     * Constructs a MembershipController with the given database and MainController.
     *
     * @param db The database instance to interact with.
     * @param mc The MainController for switching views.
     */
    public MembershipController(Database db, MainController mc) {
        this.mainController = mc;
        this.user = mainController.getUser();
        this.view = new MembershipView(user.getMember());
        this.db = db;

        // Depending on whether the user is a member or not, add the appropriate action listener.
        if (user.getMember()) {
            view.getCancelMembership().addActionListener(this);
        } else {
            view.getSignUp().addActionListener(this);
        }
    }

    /**
     * Gets the MembershipView associated with this controller.
     *
     * @return The MembershipView.
     */
    public MembershipView getView() {
        return view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getCancelMembership()) {
            // Cancel user membership and update the database.
            db.executeUpdate("UPDATE users SET member = false WHERE username = '" + user.getUsername() + "'");
            user.setMember(false);
        } else if (e.getSource() == view.getSignUp()) {
            // Sign up user for membership and update the database.
            db.executeUpdate("UPDATE users SET member = true WHERE username = '" + user.getUsername() + "'");
            user.setMember(true);
        }

        // Display a success message in a popup and navigate back to the main menu.
        JOptionPane.showMessageDialog(null, "Success!");
        mainController.switchToView("UserView");
    }
}
