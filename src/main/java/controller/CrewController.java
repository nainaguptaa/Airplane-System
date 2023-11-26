package controller;

import java.awt.event.ActionListener;
import java.util.Map;

import view.CrewView;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;


public class CrewController implements ActionListener{
    Database db;
    MainController mainController;
    CrewView crewView;
    String flightNo;

    public CrewController(Database db, MainController mc, Map<String, Object> args) {
        this.db = db;
        this.mainController = mc;
        this.flightNo = args.get("flightNo").toString();

        crewView = new CrewView(args.get("flightNo").toString());
        addListeners();
        getFlightCrew();
        getCrewDropdown();
    }

    private void addListeners() {
        crewView.addAddButtonListener(this);
        crewView.addRemoveButtonListener(this);
    }

    public CrewView getView() {
        return crewView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Crew Member")) {
            addCrewMember();
        } else if (e.getActionCommand().equals("Remove Selected Crew Member")) {
            removeCrewMember();
        }

    }

    private void removeCrewMember() {
        String username = crewView.getSelectedCrewMemberFromTable();
        String query = "DELETE FROM crew WHERE flight_id = " + flightNo + " AND username = '" + username + "'";

        System.out.println(query);

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

    private void addCrewMember() {
        String username = crewView.getSelectedCrewMemberFromDropdown();
        if (username == null) {
            crewView.addErrorMessage("Please select a crew member");
            return;
        }
        String query = "INSERT INTO crew(username, flight_id) VALUES ('" + username  + "', " + flightNo + ")";

        System.out.println(query);

        int res = db.executeUpdate(query);
        if (res == 0) {
            crewView.addErrorMessage("Error adding crew member");
            return;
        }

        crewView.addSuccessMessage("Successfully added crew member");

        crewView.addCrewMember(new Object[] { username, getUsernameEmail(username) });
        crewView.clearDropdown();
        getCrewDropdown();
    }

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

    private void getCrewDropdown(){
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

    private void getFlightCrew() {
        String query = "SELECT users.username, email FROM users, crew WHERE flight_id = " + flightNo + " AND crew.username = users.username";

        ResultSet res = db.executeQuery(query);

        try {
            while (res.next()) {
                Object[] rowData = { res.getString("username"), res.getString("email") };
                crewView.addCrewMember(rowData);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
