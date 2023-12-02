package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Represents the view for adding an aircraft.
 */
public class AddAircraftView extends JPanel {
    private JComboBox<String> modelComboBox;
    private JButton submitBtn;

    /**
     * Creates a new instance of the AddAircraftView.
     * Initializes and configures the user interface elements.
     */
    public AddAircraftView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Model Dropdown
        add(new JLabel("Model:"), gbc);
        modelComboBox = new JComboBox<>();
        add(modelComboBox, gbc);

        // Submit Button
        submitBtn = new JButton("Submit");
        add(submitBtn, gbc);
    }

    /**
     * Gets the selected model from the dropdown.
     *
     * @return The selected aircraft model.
     */
    public String getModel() {
        return modelComboBox.getSelectedItem().toString();
    }

    /**
     * Adds an ActionListener to the submit button.
     *
     * @param al The ActionListener to be added.
     */
    public void addSubmitButtonListener(ActionListener al) {
        submitBtn.addActionListener(al);
    }

    /**
     * Displays an error message dialog to the user.
     *
     * @param message The error message to be displayed.
     */
    public void addErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a success message dialog to the user.
     *
     * @param message The success message to be displayed.
     */
    public void addSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Adds an item to the model dropdown.
     *
     * @param item The item to be added to the dropdown.
     */
    public void addModelDropdownItem(String item) {
        modelComboBox.addItem(item);
    }
}
