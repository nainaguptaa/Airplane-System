package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class InfoView extends JPanel {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField contactNumberField;
    private JButton nextButton;

    public InfoView() {
        // Name
        add(createFormPanel(), BorderLayout.CENTER);
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4); // Padding

        // Username
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Name:"), gbc);
        nameField = new JTextField(10);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Email:"), gbc);
        emailField = new JTextField(10);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);



        // Password
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Contact Number:"), gbc);
        contactNumberField = new JTextField(10);
        gbc.gridx = 1;
        formPanel.add(contactNumberField, gbc);

        // Next Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        nextButton = new JButton("Next");
        formPanel.add(nextButton, gbc);

        return formPanel;
    }

    public String getName() {
        return nameField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getContactNumber() {
        return contactNumberField.getText();
    }

    public void addNextListener(ActionListener listener) {
        nextButton.addActionListener(listener);
    }
}
