package controller;

import java.awt.event.ActionListener;
import view.ManageFlightsView;
import java.awt.event.ActionEvent;

public class ManageFlightsController implements ActionListener {
    private ManageFlightsView view;
    private Database db;
    private MainController mainController;

    public ManageFlightsController(Database db, MainController mc) {
        this.mainController = mc;
        this.view = new ManageFlightsView();
        this.db = db;

        addListeners();
    }

    private void addListeners() {
        view.addAddFlightButtonListener(this);
        view.addRemoveFlightButtonListener(this);
        view.addChangeFlightButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("Add Flight")) {

        }
        else if (e.getActionCommand().equals("Remove Flight")) {

        }
        else if (e.getActionCommand().equals("Change Flight")) {

        }

    }

    public ManageFlightsView getView() {
        return view;
    }
    
}
