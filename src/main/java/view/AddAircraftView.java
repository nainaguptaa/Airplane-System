package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddAircraftView extends JPanel {
    private JComboBox<String> modelComboBox;
    private JButton submitBtn;

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

    // Getters for each field
    public String getModel() {
        return modelComboBox.getSelectedItem().toString();
    }

    // Add submit button listener
    public void addSubmitButtonListener(ActionListener al) {
        submitBtn.addActionListener(al);
    }

    public void addErrorMessage(String message){
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void addSuccessMessage(String message){
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addModelDropdownItem(String item) {
        modelComboBox.addItem(item);
    }
}
