package controller;

import view.ManageAircraftsView;
import view.AddAircraftView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

/**
 * Controller class for managing aircraft-related views and functionality.
 */
public class ManageAircraftsController implements ActionListener {
    Database db;
    MainController mainController;
    ManageAircraftsView view;
    AddAircraftView addAircraftView;

    /**
     * Constructs a new ManageAircraftsController with the given database and MainController.
     *
     * @param db The database instance to interact with.
     * @param mc The MainController for switching views.
     */
    public ManageAircraftsController(Database db, MainController mc) {
        this.db = db;
        this.mainController = mc;
        this.view = new ManageAircraftsView();
        getAircraftDropdown();
        addListeners();
    }

    /**
     * Adds action listeners to the relevant buttons in the view.
     */
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

    /**
     * Adds a new aircraft to the database.
     */
    private void addAircraft() {
        // SQL query to insert a new aircraft into the database
        String query = "INSERT INTO aircrafts (model) VALUES ('" + addAircraftView.getModel() + "')";
        int res = db.executeUpdate(query);
        char seatCol = 'A';
        int id = 0;
        int seatRow = 0;
        if (res == 0) {
            addAircraftView.addErrorMessage("Error adding aircraft");
            return;
        }

        // Get the maximum aircraft ID
        query = "SELECT MAX(aircraft_id) FROM aircrafts";
        ResultSet rs = db.executeQuery(query);
        try {
            rs.next();
            id = rs.getInt("MAX(aircraft_id)");
        } catch (Exception e) {
            System.out.println(e);
            addAircraftView.addErrorMessage("Error adding aircraft");
            return;
        }

        // Insert seat information into the database
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                query = "INSERT INTO seats (aircraft_id, seat_number, class) VALUES (" + id + ", '" + seatCol + seatRow + "', 'Business')";
                res = db.executeUpdate(query);
                if (res == 0) {
                    addAircraftView.addErrorMessage("Error adding aircraft");
                    return;
                }
                seatCol++;
            }
            seatCol = 'A';
            seatRow++;
        }

        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 6; j++) {
                query = "INSERT INTO seats (aircraft_id, seat_number, class) VALUES (" + id + ", '" + seatCol + seatRow + "', 'Comfort')";
                res = db.executeUpdate(query);
                if (res == 0) {
                    addAircraftView.addErrorMessage("Error adding aircraft");
                    return;
                }
                seatCol++;
            }
            seatCol = 'A';
            seatRow++;
        }

        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                query = "INSERT INTO seats (aircraft_id, seat_number, class) VALUES (" + id + ", '" + seatCol + seatRow + "', 'ordinary')";
                res = db.executeUpdate(query);
                if (res == 0) {
                    addAircraftView.addErrorMessage("Error adding aircraft");
                    return;
                }
                seatCol++;
            }
            seatCol = 'A';
            seatRow++;
        }


        addAircraftView.addSuccessMessage("Aircraft added successfully");
    }

    /**
     * Retrieves aircraft IDs from the database and adds them to the view's dropdown.
     */
    private void getAircraftDropdown() {
        String query = "SELECT aircraft_id FROM aircrafts";
        ResultSet rs = db.executeQuery(query);
        try {
            while (rs.next()) {
                view.addAircraftDropdownItem(rs.getString("aircraft_id"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Retrieves aircraft models from the database and adds them to the AddAircraftView's dropdown.
     */
    private void getAircraftModelDropdown() {
        String query = "SELECT model FROM aircraftTypes";
        ResultSet rs = db.executeQuery(query);
        try {
            while (rs.next()) {
                addAircraftView.addModelDropdownItem(rs.getString("model"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Removes an aircraft from the database based on the selected aircraft ID in the view.
     */
    private void removeAircraft() {
        String query = "DELETE FROM aircrafts WHERE aircraft_id = " + view.getAircraftID();
        int res = db.executeUpdate(query);
        if (res == 0) {
            view.addErrorMessage("Error removing aircraft");
            return;
        }
        view.addSuccessMessage("Aircraft removed successfully");
        view.clearAircraftDropdown();
        getAircraftDropdown();
    }

    /**
     * Gets the ManageAircraftsView associated with this controller.
     *
     * @return The ManageAircraftsView.
     */
    public ManageAircraftsView getView() {
        return view;
    }

    /**
     * Gets the AddAircraftView associated with this controller.
     *
     * @return The AddAircraftView.
     */
    public AddAircraftView getAddAircraftView() {
        return addAircraftView;
    }
}
