package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import utils.Buttons;

/**
 * The ManageAircraftsView class represents the view for managing aircrafts.
 */
public class ManageAircraftsView extends JPanel {
    private JButton addAircraftButton;
    private JButton removeAircraftButton;
    private JComboBox<String> aircraftIDComboBox; // Changed to JComboBox

    /**
     * Constructs a new ManageAircraftsView.
     */
    public ManageAircraftsView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Section for Adding Aircrafts
        JPanel addAircraftPanel = new JPanel();
        addAircraftPanel.setLayout(new BoxLayout(addAircraftPanel, BoxLayout.Y_AXIS));
        addAircraftButton = createStyledButton("Add Aircraft");
        addAircraftButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addAircraftPanel.add(addAircraftButton);
        add(addAircraftPanel, gbc);

        // Add Space
        add(Box.createRigidArea(new Dimension(0, 20)), gbc);

        // Section for Changing and Removing Aircrafts
        JPanel manageAircraftsPanel = new JPanel();
        manageAircraftsPanel.setLayout(new BoxLayout(manageAircraftsPanel, BoxLayout.Y_AXIS));
        
        // Aircraft ID ComboBox
        JPanel aircraftIDPanel = new JPanel();
        aircraftIDPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        aircraftIDComboBox = new JComboBox<>(); // Initialize the JComboBox
        aircraftIDComboBox.setPreferredSize(new Dimension(200, 25)); // Set size
        aircraftIDPanel.add(new JLabel("Aircraft ID: "));
        aircraftIDPanel.add(aircraftIDComboBox);
        manageAircraftsPanel.add(aircraftIDPanel);
        // Remove Aircraft Buttons
        removeAircraftButton = createStyledButton("Remove Aircraft");
        aircraftIDPanel.add(removeAircraftButton);

        add(manageAircraftsPanel, gbc);
    }

    private JButton createStyledButton(String text) {
        return Buttons.createStyledButton(
            text,
            text,
            new Dimension(180, 40),
            new Color(100, 181, 246),
            new Font("Arial", Font.BOLD, 14));
    }

    /**
     * Adds an ActionListener for the "Add Aircraft" button.
     *
     * @param al The ActionListener to be added for the "Add Aircraft" button.
     */
    public void addAddAircraftButtonListener(ActionListener al) {
        addAircraftButton.addActionListener(al);
    }

    /**
     * Adds an ActionListener for the "Remove Aircraft" button.
     *
     * @param al The ActionListener to be added for the "Remove Aircraft" button.
     */
    public void addRemoveAircraftButtonListener(ActionListener al) {
        removeAircraftButton.addActionListener(al);
    }

    /**
     * Gets the selected aircraft ID from the JComboBox.
     *
     * @return The selected aircraft ID.
     */
    public String getAircraftID() {
        return (String) aircraftIDComboBox.getSelectedItem();
    }

    /**
     * Adds an aircraft ID item to the JComboBox.
     *
     * @param aircraftID The aircraft ID to be added to the JComboBox.
     */
    public void addAircraftDropdownItem(String aircraftID) {
        aircraftIDComboBox.addItem(aircraftID);
    }

    /**
     * Displays an error message dialog.
     *
     * @param message The error message to be displayed.
     */
    public void addErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a success message dialog.
     *
     * @param message The success message to be displayed.
     */
    public void addSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Clears the aircraft ID dropdown by removing all items.
     */
    public void clearAircraftDropdown() {
        aircraftIDComboBox.removeAllItems();
    }
}
