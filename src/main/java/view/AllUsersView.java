package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * The AllUsersView class represents a view for displaying a list of all registered users.
 */
public class AllUsersView extends JPanel {

    private JTable usersTable;
    private DefaultTableModel tableModel;

    /**
     * Creates a new AllUsersView panel.
     */
    public AllUsersView() {
        // Setting up the panel
        setSize(600, 400);
        setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("All Registered Users");
        titleLabel.setBounds(200, 10, 200, 30);
        add(titleLabel);

        // Define column names for users table
        String[] columnNames = {"Username", "First Name", "Last Name", "Address", "Email", "Role", "Member"};

        // Initialize the table model and set column names
        tableModel = new DefaultTableModel(columnNames, 0);
        usersTable = new JTable(tableModel);

        // Scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(usersTable);
        scrollPane.setBounds(50, 50, 500, 300);
        add(scrollPane);
    }

    /**
     * Updates the table with a list of users' data.
     *
     * @param usersData An ArrayList of String arrays representing user data.
     */
    public void updateTable(ArrayList<String[]> usersData) {
        // Clear the table
        tableModel.setRowCount(0);

        // Add each user to the table
        for (String[] userData : usersData) {
            tableModel.addRow(userData);
        }
    }

    /**
     * Adds a new user to the table.
     *
     * @param userData A String array representing user data.
     */
    public void addUser(String[] userData) {
        tableModel.addRow(userData);
    }

}
