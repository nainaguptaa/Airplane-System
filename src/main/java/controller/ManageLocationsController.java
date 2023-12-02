package controller;

import java.awt.event.ActionListener;
import view.ManageLocationsView;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

/**
 * Controller class for managing locations-related views and functionality.
 */
public class ManageLocationsController implements ActionListener {
    Database db;
    MainController mc;
    ManageLocationsView mlv;

    /**
     * Constructs a new ManageLocationsController with the given database and MainController.
     *
     * @param db The database instance to interact with.
     * @param mc The MainController for switching views.
     */
    public ManageLocationsController(Database db, MainController mc) {
        this.db = db;
        this.mc = mc;
        this.mlv = new ManageLocationsView();
        addListeners();
    }

    /**
     * Adds action listeners to the relevant buttons in the view.
     */
    private void addListeners() {
        mlv.addAddLocationButtonListener(this);
        mlv.addRemoveLocationButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Add Location")) {
            addLocation();
        } else if (action.equals("Remove Location")) {
            removeLocation();
        }
    }

    /**
     * Checks if a location code is in a valid format (e.g., 'XXX' with uppercase letters).
     *
     * @param code The location code to validate.
     * @return true if the code is valid, false otherwise.
     */
    private boolean isValidCode(String code) {
        return Pattern.matches("^[A-Z]{3}$", code);
    }

    /**
     * Handles the addition of a new location to the database.
     */
    private void addLocation() {
        String code = mlv.getCode();
        if (!isValidCode(code)) {
            mlv.addErrorMessage("Code must be in the format 'XXX' with uppercase letters.");
            return;
        }
        String city = mlv.getCity();
        String state = mlv.getState();
        String country = mlv.getCountry();
        if (code.equals("") || city.equals("") || state.equals("") || country.equals("")) {
            mlv.addErrorMessage("Please fill in all fields.");
        } else {
            String query = "INSERT INTO locations (code, city, state, country) VALUES ('" + code + "', '" + city + "', '"
                    + state + "', '" + country + "');";

            int res = db.executeUpdate(query);
            if (res == 0) {
                mlv.addErrorMessage("Location already exists.");
                return;
            }
            mlv.addSuccessMessage("Location added successfully.");
            mlv.clearTextFields();
        }
    }

    /**
     * Handles the removal of a location from the database.
     */
    private void removeLocation() {
        String code = mlv.getCode();
        if (code.equals("")) {
            mlv.addErrorMessage("Please fill in the code field.");
        } else if (!isValidCode(code)) {
            mlv.addErrorMessage("Code must be in the format 'XXX' with uppercase letters.");
            return;
        } else {
            String query = "DELETE FROM locations WHERE code = '" + code + "';";
            int res = db.executeUpdate(query);
            if (res == 0) {
                mlv.addErrorMessage("Location does not exist.");
                return;
            }
            mlv.addSuccessMessage("Location removed successfully.");
            mlv.clearTextFields();
        }
    }

    /**
     * Gets the ManageLocationsView associated with this controller.
     *
     * @return The ManageLocationsView.
     */
    public ManageLocationsView getView() {
        return mlv;
    }
}
