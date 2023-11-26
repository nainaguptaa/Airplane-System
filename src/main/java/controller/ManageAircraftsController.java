package controller;

import view.ManageAircraftsView;
import view.AddAircraftView;
import java.awt.event.ActionListener;

import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;


public class ManageAircraftsController implements ActionListener{
    Database db;
    MainController mainController;
    ManageAircraftsView view;
    AddAircraftView addAircraftView;

    public ManageAircraftsController(Database db, MainController mc) {
        this.db = db;
        this.mainController = mc;
        this.view = new ManageAircraftsView();
        getAircraftDropdown();
        addListeners();
    }

    private void addListeners() {
        view.addAddAircraftButtonListener(this);
        view.addRemoveAircraftButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("Add Aircraft")) {
            addAircraftView = new AddAircraftView();
            getAircraftModelDropdown();
            addAircraftView.addSubmitButtonListener(this);
            mainController.switchToView("AddAircraftView");
        } else if (e.getActionCommand().equals("Remove Aircraft")) {
            removeAircraft();
        } else if (e.getActionCommand().equals("Submit")) {
            addAircraft();
        }
    }

    private void addAircraft() {
        String query = "INSERT INTO aircrafts (model) VALUES ('" + addAircraftView.getModel() + "')";
        int res = db.executeUpdate(query);
        if(res == 0){
            addAircraftView.addErrorMessage("Error adding aircraft");
            return;
        }
        addAircraftView.addSuccessMessage("Aircraft added successfully");
    }

    private void getAircraftDropdown() {
        String query = "SELECT aircraft_id FROM aircrafts";
        ResultSet rs = db.executeQuery(query);
        try{
            while(rs.next()){
                view.addAircraftDropdownItem(rs.getString("aircraft_id"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private void getAircraftModelDropdown(){
        String query = "SELECT model FROM aircraftTypes";
        ResultSet rs = db.executeQuery(query);
        try{
            while(rs.next()){
                addAircraftView.addModelDropdownItem(rs.getString("model"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private void removeAircraft(){
        String query = "DELETE FROM aircrafts WHERE aircraft_id = " + view.getAircraftID();
        int res = db.executeUpdate(query);
        if(res == 0){
            view.addErrorMessage("Error removing aircraft");
            return;
        }
        view.addSuccessMessage("Aircraft removed successfully");
        view.clearAircraftDropdown();
        getAircraftDropdown();
    }

    public ManageAircraftsView getView() {
        return view;
    }

    public AddAircraftView getAddAircraftView() {
        return addAircraftView;
    }
}
