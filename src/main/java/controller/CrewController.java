package controller;

import java.awt.event.ActionListener;
import java.util.Map;

import view.CrewView;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

/**
 * The CrewController class manages the interaction between the database, CrewView,
 * and other controllers for handling flight crew information.
 */
public class CrewController implements ActionListener {
    private Database db;
    private MainController mainController;
    private CrewView crewView;
    private String flightNo;

    /**
     * Constructs a CrewController.
     *
     * @param db    The database instance to access crew and user data.
     * @param mc    The MainController for managing the application's main views.
     * @param args  A map of arguments, including "flightNo" to identify the flight.
     */
    public CrewController(Database db, MainController mc, Map<String, Object> args) {
        this.db = db;
        this.mainController = mc;
        this.flightNo = args.get("flightNo").toString();

        crewView = new CrewView(args.get("flightNo").toString());
        addListeners();
        getFlightCrew();
        getCrewDropdown();
    }

    /**
     * Adds action listeners to buttons in the CrewView.
     */
    private void addListeners() {
        crewView.addAddButtonListener(this);
        crewView.addRemoveButtonListener(this);
    }

    /**
     * Gets the CrewView associated with this controller.
     *
     * @return The CrewView instance.
     */
    public CrewView getView() {
        return crewView;
    }

    /**
     * Handles button actions in the CrewView.
     *
     * @param e The ActionEvent triggered by button actions.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Crew Member")) {
            addCrewMember();
        } else if (e.getActionCommand().equals("Remove Selected Crew Member")) {
            removeCrewMember();
        }
    }

    /**
     * Removes a selected crew member from the flight crew.
     */
    private void removeCrewMember() {
        String username = crewView.getSelectedCrewMemberFromTable();
        String query = "DELETE FROM crew WHERE flight_id = " + flightNo + " AND username = '" + username + "'";

        int res = db.executeUpdate(query);
        if (res == 0) {
            crewView.addErrorMessage("Error removing crew member");
            return;
        }

        crewView.addSuccessMessage("Successfully removed crew member");

        crewView.removeSelectedCrewMember();
        crewView.clearDropdown();
        getCrewDropdown();
    }

    /**
     * Adds a selected crew member to the flight crew.
     */
    private void addCrewMember() {
        String username = crewView.getSelectedCrewMemberFromDropdown();
        if (username == null) {
            crewView.addErrorMessage("Please select a crew member");
            return;
        }
        String query = "INSERT INTO crew(username, flight_id) VALUES ('" + username + "', " + flightNo + ")";

        int res = db.executeUpdate(query);
        if (res == 0) {
            crewView.addErrorMessage("Error adding crew member");
            return;
        }

        crewView.addSuccessMessage("Successfully added crew member");

        crewView.addCrewMember(new Object[]{username, getUsernameEmail(username)});
        crewView.clearDropdown();
        getCrewDropdown();
    }

    /**
     * Retrieves the email associated with a given username.
     *
     * @param username The username of the crew member.
     * @return The email address as a string.
     */
    private String getUsernameEmail(String username) {
        String query = "SELECT email FROM users WHERE username = '" + username + "'";

        ResultSet res = db.executeQuery(query);

        try {
            while (res.next()) {
                return res.getString("email");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves a list of crew members that can be added to the flight crew.
     */
    private void getCrewDropdown() {
        String query = "SELECT username FROM users WHERE role = 3 AND username NOT IN (SELECT username FROM crew WHERE flight_id = " + flightNo + ")";

        ResultSet res = db.executeQuery(query);

        try {
            while (res.next()) {
                crewView.addCrewMemberDropdownItem(res.getString("username"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retrieves the current flight crew for the specified flight.
     */
    private void getFlightCrew() {
        String query = "SELECT users.username, email FROM users, crew WHERE flight_id = " + flightNo + " AND crew.username = users.username";

        ResultSet res = db.executeQuery(query);

        try {
            while (res.next()) {
                Object[] rowData = {res.getString("username"), res.getString("email")};
                crewView.addCrewMember(rowData);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
