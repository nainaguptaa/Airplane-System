package controller;

import view.AllUsersView;
import java.sql.ResultSet;
import model.role.User;

/**
 * The AllUsersController class manages the interaction between the database and
 * the AllUsersView for displaying all user information.
 */
public class AllUsersController {
    private Database db;
    private MainController mainController;
    private AllUsersView allUsersView;

    /**
     * Constructs an AllUsersController.
     *
     * @param db The database instance to access user data.
     * @param mc The MainController for managing the application's main views.
     */
    public AllUsersController(Database db, MainController mc) {
        this.db = db;
        this.mainController = mc;

        allUsersView = new AllUsersView();
        getUsers();
    }

    /**
     * Gets the AllUsersView associated with this controller.
     *
     * @return The AllUsersView instance.
     */
    public AllUsersView getView() {
        return allUsersView;
    }

    /**
     * Retrieves user data from the database and populates the AllUsersView with the data.
     */
    private void getUsers() {
        String query = "SELECT username, first_name, last_name, address, email, role, member FROM users";

        ResultSet rs = db.executeQuery(query);
        try {
            while (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                int role = rs.getInt("role");
                boolean member = rs.getBoolean("member");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String address = rs.getString("address");

                // Create an array with user data and add it to the view
                String[] userData = {username, firstName, lastName, address, email, User.roleToString(role), Boolean.toString(member)};
                allUsersView.addUser(userData);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
