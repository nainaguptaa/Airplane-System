package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;

public class BookingsView extends JPanel {
    private JTable bookingsTable;
    private JButton manageButton;
    private JButton cancelButton;

    public BookingsView() {
        setLayout(new BorderLayout());

        // Column Names
        String[] columnNames = {"Booking ID", "Date", "Status"}; // Modify as needed

        // Sample Data
        String[][] data = {
            {"001", "2023-11-23", "Confirmed"},
            {"002", "2023-11-24", "Pending"},
            // Add more bookings data
        };

        // Table Model
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        bookingsTable = new JTable(model);

        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(bookingsTable);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel with Buttons
        JPanel bottomPanel = new JPanel();
        manageButton = new JButton("Manage");
        cancelButton = new JButton("Cancel");
        // Add listeners and functionality to buttons
        bottomPanel.add(manageButton);
        bottomPanel.add(cancelButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void updateButtons() {
        // boolean isSelected = !bookingsList.isSelectionEmpty();
        // manageButton.setEnabled(isSelected);
        // cancelButton.setEnabled(isSelected);
    }

    public void addManageButtonListener(ActionListener actionListener) {
        manageButton.addActionListener(actionListener);
    }

    public void addCancelButtonListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    // Method to update the bookings list
    // public void setBookingsListData(String[][] bookingsData) { // Replace String[] with your bookings data type
    //     bookingsTable.set
    // }
}
