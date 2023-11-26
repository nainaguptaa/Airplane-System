package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import java.awt.event.ActionListener;

public class CrewView extends JPanel {

    private JTable crewTable;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JButton addButton;
    private JButton removeButton;
    private JComboBox<String> crewMemberComboBox;
    private String flightNo;

    public CrewView(String flightNo) {
        this.flightNo = flightNo;

        // Setting up the panel
        setSize(600, 400);
        setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("Viewing Crew for Flight " + flightNo);
        titleLabel.setBounds(150, 10, 300, 30);
        add(titleLabel);

        // Define column names for crew table
        String[] columnNames = {"Name", "Email"};

        // Initialize the table model and set column names
        tableModel = new DefaultTableModel(columnNames, 0);
        crewTable = new JTable(tableModel);

        // Scroll pane for the table
        scrollPane = new JScrollPane(crewTable);
        scrollPane.setBounds(50, 50, 500, 250);
        add(scrollPane);

        // Add button
        addButton = new JButton("Add Crew Member");
        addButton.setBounds(150, 350, 160, 30);
        add(addButton);

        // Remove button
        removeButton = new JButton("Remove Selected Crew Member");
        removeButton.setBounds(320, 350, 200, 30);
        add(removeButton);
        removeButton.setEnabled(false);

        // Crew Member ComboBox
        crewMemberComboBox = new JComboBox<>();
        crewMemberComboBox.setBounds(150, 310, 300, 30);
        add(crewMemberComboBox);

                crewTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // This check is necessary to prevent double events
                    updateRemoveButtonState();
                }
            }
        });
    }

    public void addCrewMember(Object[] rowData) {
        tableModel.addRow(rowData);
    }

    public void removeSelectedCrewMember() {
        int selectedRow = crewTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        }
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addRemoveButtonListener(ActionListener listener) {
        removeButton.addActionListener(listener);
    }

    public void updateTable(ArrayList<String[]> crewMembers){
        tableModel.setRowCount(0);
        for (String[] crewMember : crewMembers) {
            tableModel.addRow(crewMember);
        }
    }

    public void clearDropdown() {
        crewMemberComboBox.removeAllItems();
    }

    public void addCrewMemberDropdownItem(String crewMember) {
        crewMemberComboBox.addItem(crewMember);
    }

    public String getSelectedCrewMemberFromDropdown() {
        return (String) crewMemberComboBox.getSelectedItem();
    }
    
    public String getSelectedCrewMemberFromTable() {
        int selectedRow = crewTable.getSelectedRow();
        if (selectedRow != -1) {
            return (String) crewTable.getValueAt(selectedRow, 0);
        }
        return null;
    }

    private void updateRemoveButtonState() {
        // Enable the remove button if a row is selected, disable it otherwise
        removeButton.setEnabled(crewTable.getSelectedRow() != -1);
    }

    public void addSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Additional methods can be added as needed, e.g., to refresh crew list, handle errors, etc.
}
