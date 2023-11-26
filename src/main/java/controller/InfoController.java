package controller;

import view.InfoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class InfoController implements ActionListener {
    private InfoView infoView;
    private MainController mainController;
    private Database db;

    private Map<String, Object> args;

    public InfoController(Database db, MainController mc) {
        this.db = db;
        this.mainController = mc;

        infoView = new InfoView();

        // Adding action listener to the submit button
        infoView.addNextListener(this);
    }

    public Map<String, Object>getArgs () {
    	return args;
    }

    public void setArgs(Map<String, Object> args) {
    	this.args = args;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleFormSubmission();
    }

    private void handleFormSubmission() {
        // Get data from the view
        String name = infoView.getName();
        String email = infoView.getEmail();
        String contactNumber = infoView.getContactNumber();

        HashMap<String, Object> guestInfo = new HashMap<>();
        guestInfo.put("name", name);
        guestInfo.put("email", email);
        guestInfo.put("contactNumber", contactNumber);
        guestInfo.put("booking", args.get("booking"));


        mainController.switchToViewWithArgs("SeatMapView", guestInfo);
    }

    public InfoView getView() {
        return infoView;
    }
}
