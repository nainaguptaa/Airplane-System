package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import utils.Buttons;

/**
 * The ManageLocationsView class represents the view for managing location details.
 */
public class ManageLocationsView extends JPanel {
    private JButton addLocationButton;
    private JButton removeLocationButton;
    private JTextField codeTextField;
    private JTextField cityTextField;
    private JTextField stateTextField;
    private JTextField countryTextField;

    /**
     * Constructs a new ManageLocationsView.
     */
    public ManageLocationsView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Header
        JLabel header = new JLabel("Manage Locations");
        header.setFont(new Font("Arial", Font.BOLD, 18));
        header.setHorizontalAlignment(JLabel.CENTER);
        add(header, gbc);

        // Add Space
        add(Box.createRigidArea(new Dimension(0, 20)), gbc);

        // Location Details Panel
        JPanel locationDetailsPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        // Input Fields for Location Details
        locationDetailsPanel.add(new JLabel("Code:"));
        codeTextField = new JTextField(10);
        locationDetailsPanel.add(codeTextField);

        locationDetailsPanel.add(new JLabel("City:"));
        cityTextField = new JTextField(10);
        locationDetailsPanel.add(cityTextField);

        locationDetailsPanel.add(new JLabel("State:"));
        stateTextField = new JTextField(10);
        locationDetailsPanel.add(stateTextField);

        locationDetailsPanel.add(new JLabel("Country:"));
        countryTextField = new JTextField(10);
        locationDetailsPanel.add(countryTextField);

        add(locationDetailsPanel, gbc);

        // Add Space
        add(Box.createRigidArea(new Dimension(0, 20)), gbc);

        // Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        addLocationButton = createStyledButton("Add Location");
        removeLocationButton = createStyledButton("Remove Location");
        buttonsPanel.add(addLocationButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonsPanel.add(removeLocationButton);

        add(buttonsPanel, gbc);
    }

    /**
     * Creates a styled button with the given text.
     *
     * @param text The text to be displayed on the button.
     * @return The styled JButton.
     */
    private JButton createStyledButton(String text) {
        return Buttons.createStyledButton(
            text,
            text,
            new Dimension(180, 40),
            new Color(100, 181, 246),
            new Font("Arial", Font.BOLD, 14));
    }

    /**
     * Gets the code entered in the text field.
     *
     * @return The entered code.
     */
    public String getCode() {
        return codeTextField.getText();
    }

    /**
     * Gets the city entered in the text field.
     *
     * @return The entered city.
     */
    public String getCity() {
        return cityTextField.getText();
    }

    /**
     * Gets the state entered in the text field.
     *
     * @return The entered state.
     */
    public String getState() {
        return stateTextField.getText();
    }

    /**
     * Gets the country entered in the text field.
     *
     * @return The entered country.
     */
    public String getCountry() {
        return countryTextField.getText();
    }

    /**
     * Adds an ActionListener for the "Add Location" button.
     *
     * @param al The ActionListener to be added.
     */
    public void addAddLocationButtonListener(ActionListener al) {
        addLocationButton.addActionListener(al);
    }

    /**
     * Adds an ActionListener for the "Remove Location" button.
     *
     * @param al The ActionListener to be added.
     */
    public void addRemoveLocationButtonListener(ActionListener al) {
        removeLocationButton.addActionListener(al);
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
     * Clears the text fields for location details.
     */
    public void clearTextFields() {
        codeTextField.setText("");
        cityTextField.setText("");
        stateTextField.setText("");
        countryTextField.setText("");
    }
}
