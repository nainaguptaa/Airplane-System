package controller;

import view.MembershipView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  model.role.User;

import javax.swing.*;

public class MembershipController implements ActionListener {

    private MembershipView view;
    private Database db;
    private MainController mainController;
    private User user;

    public MembershipController(Database db, MainController mc) {
        this.mainController = mc;
        this.user = mainController.getUser();
        this.view = new MembershipView(user.getMember());
        this.db = db;

        if (user.getMember()) {
            view.getCancelMembership().addActionListener(this);
        } else {
            view.getSignUp().addActionListener(this);
        }
    }



    public MembershipView getView() {
        return view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getCancelMembership()) {
            db.executeUpdate("UPDATE users SET member = false WHERE username = '" + user.getUsername() + "'");
            user.setMember(false);
        } else if (e.getSource() == view.getSignUp()) {
            db.executeUpdate("UPDATE users SET member = true WHERE username = '" + user.getUsername() + "'");
            user.setMember(true);
        }

        // Popup message saying success and then naviagte back to main menu
        JOptionPane.showMessageDialog(null, "Success!");
        mainController.switchToView("UserView");
    }


}
