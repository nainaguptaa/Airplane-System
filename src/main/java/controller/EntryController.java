package  controller;

import javax.swing.Action;

import  view.EntryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  model.role.User;

public class EntryController implements ActionListener {
    private EntryView entryView;
    private Database db;
    private MainController mainController;

    public EntryController(Database db, MainController mainController) {
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
