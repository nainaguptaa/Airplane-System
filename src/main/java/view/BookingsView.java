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
    private DefaultTableModel model;
    private JButton manageButton;
    private JButton cancelButton;

    public BookingsView(ArrayList<String[]> bookingsData) {
        setLayout(new BorderLayout());

        // Column Names
        String[] columnNames = { "Booking ID, Flight ID", "Seat ID", "Insurance", "Price", "Booking Time" };

        // Table Model
        model = new DefaultTableModel(convertToArray(bookingsData), columnNames);
        bookingsTable = new JTable(model);

        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(bookingsTable);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel with Buttons
        JPanel bottomPanel = new JPanel();
        manageButton = new JButton("Manage");
        cancelButton = new JButton("Cancel");
        bottomPanel.add(manageButton);
        bottomPanel.add(cancelButton);
        add(bottomPanel, BorderLayout.SOUTH);

        updateButtons(); // Set initial state of buttons
    }

    public void addManageButtonListener(ActionListener actionListener) {
        manageButton.addActionListener(actionListener);
    }

    public void addCancelButtonListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    public void addTableListener(ListSelectionListener listSelectionListener) {
        bookingsTable.getSelectionModel().addListSelectionListener(listSelectionListener);
    }

    public void updateTable(ArrayList<String[]> bookingsData) {
        String[][] data = convertToArray(bookingsData);
        model.setDataVector(data, new String[] { "Flight ID", "Seat ID", "Insurance", "Price", "Booking Time" });
        model.fireTableDataChanged(); // Notify the model that its data has changed
    }

    private String[][] convertToArray(ArrayList<String[]> bookingsData) {
        String[][] data = new String[bookingsData.size()][5];
        for (int i = 0; i < bookingsData.size(); i++) {
            data[i] = bookingsData.get(i);
        }
        return data;
    }

    public void updateButtons() {
        boolean isSelected = bookingsTable.getSelectedRow() != -1;
        manageButton.setEnabled(isSelected);
        cancelButton.setEnabled(isSelected);
    }

    public int getSelectedBooking() {
        //return booking ID
        return Integer.parseInt((String) bookingsTable.getValueAt(bookingsTable.getSelectedRow(), 0));
    }
}
