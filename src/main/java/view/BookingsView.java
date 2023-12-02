package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;

/**
 * The BookingsView class represents a view for displaying a list of bookings.
 */
public class BookingsView extends JPanel {
    private JTable bookingsTable;
    private DefaultTableModel model;
    private JButton cancelButton;

    /**
     * Creates a new BookingsView with the provided bookings data.
     *
     * @param bookingsData An ArrayList of String arrays representing booking data.
     */
    public BookingsView(ArrayList<String[]> bookingsData) {
        setLayout(new BorderLayout());

        // Column Names
        String[] columnNames = { "Booking ID", "Flight ID", "Seat ID", "Insurance", "Price", "Booking Time" };

        // Table Model
        model = new DefaultTableModel(convertToArray(bookingsData), columnNames);
        bookingsTable = new JTable(model);

        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(bookingsTable);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel with Buttons
        JPanel bottomPanel = new JPanel();
        cancelButton = new JButton("Cancel");
        bottomPanel.add(cancelButton);
        add(bottomPanel, BorderLayout.SOUTH);

        updateButtons(); // Set initial state of buttons
    }

    /**
     * Adds an ActionListener to the Cancel button.
     *
     * @param actionListener The ActionListener to be added to the Cancel button.
     */
    public void addCancelButtonListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    /**
     * Adds a ListSelectionListener to the bookings table.
     *
     * @param listSelectionListener The ListSelectionListener to be added to the bookings table.
     */
    public void addTableListener(ListSelectionListener listSelectionListener) {
        bookingsTable.getSelectionModel().addListSelectionListener(listSelectionListener);
    }

    /**
     * Updates the table with new bookings data.
     *
     * @param bookingsData An ArrayList of String arrays representing booking data to update the table with.
     */
    public void updateTable(ArrayList<String[]> bookingsData) {
        String[][] data = convertToArray(bookingsData);
        model.setDataVector(data, new String[] { "Flight ID", "Seat ID", "Insurance", "Price", "Booking Time" });
        model.fireTableDataChanged(); // Notify the model that its data has changed
    }

    /**
     * Converts an ArrayList of String arrays to a 2D array of Strings.
     *
     * @param bookingsData An ArrayList of String arrays to be converted.
     * @return A 2D array of Strings.
     */
    private String[][] convertToArray(ArrayList<String[]> bookingsData) {
        String[][] data = new String[bookingsData.size()][5];
        for (int i = 0; i < bookingsData.size(); i++) {
            data[i] = bookingsData.get(i);
        }
        return data;
    }

    /**
     * Updates the state of buttons based on the selected row in the table.
     */
    public void updateButtons() {
        boolean isSelected = bookingsTable.getSelectedRow() != -1;
        cancelButton.setEnabled(isSelected);
    }

    /**
     * Gets the booking ID of the selected booking in the table.
     *
     * @return The booking ID as an integer.
     */
    public int getSelectedBooking() {
        // Return booking ID
        return Integer.parseInt((String) bookingsTable.getValueAt(bookingsTable.getSelectedRow(), 0));
    }
}
