package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class AllUsersView extends JPanel {

    private JTable usersTable;
    private DefaultTableModel tableModel;

    public AllUsersView() {
        // Setting up the panel
        setSize(600, 400);
        setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("All Registered Users");
        titleLabel.setBounds(200, 10, 200, 30);
        add(titleLabel);

        // Define column names for users table
        String[] columnNames = {"Username", "Email", "Role"};

        // Initialize the table model and set column names
        tableModel = new DefaultTableModel(columnNames, 0);
        usersTable = new JTable(tableModel);

        // Scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(usersTable);
        scrollPane.setBounds(50, 50, 500, 300);
        add(scrollPane);
    }

    public void updateTable(ArrayList<String[]> usersData) {
        // Clear the table
        tableModel.setRowCount(0);

        // Add each user to the table
        for (String[] userData : usersData) {
            tableModel.addRow(userData);
        }
    }

    public void addUser(String[] userData) {
        tableModel.addRow(userData);
    }

    // Additional methods can be added as needed, e.g., to refresh user list, handle errors, etc.
}