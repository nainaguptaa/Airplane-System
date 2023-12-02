package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import utils.Buttons;

/**
 * The ManageFlightsView class represents the view for managing flights.
 */
public class ManageFlightsView extends JPanel {
    private JButton addFlightButton;
    private JButton removeFlightButton;
    private JButton changeFlightButton;
    private JComboBox<String> flightIDComboBox; // Changed to JComboBox

    /**
     * Constructs a new ManageFlightsView.
     */
    public ManageFlightsView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Section for Adding Flights
        JPanel addFlightPanel = new JPanel();
        addFlightPanel.setLayout(new BoxLayout(addFlightPanel, BoxLayout.Y_AXIS));
        addFlightButton = createStyledButton("Add Flight");
        addFlightButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addFlightPanel.add(addFlightButton);
        add(addFlightPanel, gbc);

        // Add Space
        add(Box.createRigidArea(new Dimension(0, 20)), gbc);

        // Section for Changing and Removing Flights
        JPanel manageFlightsPanel = new JPanel();
        manageFlightsPanel.setLayout(new BoxLayout(manageFlightsPanel, BoxLayout.Y_AXIS));
        
        // Flight ID ComboBox
        JPanel flightIDPanel = new JPanel();
        flightIDPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        flightIDComboBox = new JComboBox<>(); // Initialize the JComboBox
        flightIDComboBox.setPreferredSize(new Dimension(200, 25)); // Set size
        flightIDPanel.add(new JLabel("Flight ID: "));
        flightIDPanel.add(flightIDComboBox);
        manageFlightsPanel.add(flightIDPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        // Change and Remove Flight Buttons
        removeFlightButton = createStyledButton("Remove Flight");
        changeFlightButton = createStyledButton("Change Flight");
        buttonPanel.add(removeFlightButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(changeFlightButton);
        manageFlightsPanel.add(buttonPanel);

        add(manageFlightsPanel, gbc);
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
     * Adds an ActionListener for the "Add Flight" button.
     *
     * @param al The ActionListener to be added for the "Add Flight" button.
     */
    public void addAddFlightButtonListener(ActionListener al) {
        addFlightButton.addActionListener(al);
    }

    /**
     * Adds an ActionListener for the "Remove Flight" button.
     *
     * @param al The ActionListener to be added for the "Remove Flight" button.
     */
    public void addRemoveFlightButtonListener(ActionListener al) {
        removeFlightButton.addActionListener(al);
    }

    /**
     * Adds an ActionListener for the "Change Flight" button.
     *
     * @param al The ActionListener to be added for the "Change Flight" button.
     */
    public void addChangeFlightButtonListener(ActionListener al) {
        changeFlightButton.addActionListener(al);
    }

    /**
     * Gets the selected flight ID from the JComboBox.
     *
     * @return The selected flight ID.
     */
    public String getFlightID() {
        return (String) flightIDComboBox.getSelectedItem();
    }

    /**
     * Adds a flight ID item to the JComboBox.
     *
     * @param flightID The flight ID to be added to the JComboBox.
     */
    public void addFlightDropdownItem(String flightID) {
        flightIDComboBox.addItem(flightID);
    }

    /**
     * Displays an error message dialog.
     *
     * @param message The error message to be displayed.
     */
    public void addErrorMessage(String message){
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a success message dialog.
     *
     * @param message The success message to be displayed.
     */
    public void addSuccessMessage(String message){
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Clears the flight ID dropdown by removing all items.
     */
    public void clearFlightDropdown() {
        flightIDComboBox.removeAllItems();
    }
}
