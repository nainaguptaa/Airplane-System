package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The LoginView class represents the view for user login.
 */
public class LoginView extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JButton loginBtn;
    private JButton registerBtn;
    private JButton backBtn;
    private JLabel messageLabel; // Label to display messages
    private JPanel btnPanel;

    /**
     * Constructs a new LoginView.
     */
    public LoginView() {
        setSize(450, 300);
        setBackground(new Color(230, 230, 250));

        // Using BorderLayout for overall layout
        btnPanel = createButtonPanel();
        setLayout(new BorderLayout(10, 10));
        add(createFormPanel(), BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        add(createMessagePanel(), BorderLayout.NORTH); // Add message panel at the top
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4); // Padding

        // Username
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Username:"), gbc);
        username = new JTextField(10);
        gbc.gridx = 1;
        formPanel.add(username, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Password:"), gbc);
        password = new JPasswordField(10);
        gbc.gridx = 1;
        formPanel.add(password, gbc);

        return formPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Login Button
        loginBtn = new JButton("Login");
        buttonPanel.add(loginBtn);

        // Register Button
        registerBtn = new JButton("Register");

        // Back Button
        backBtn = new JButton("Back");
        buttonPanel.add(backBtn);

        return buttonPanel;
    }

    private JPanel createMessagePanel() {
        JPanel messagePanel = new JPanel();
        messageLabel = new JLabel(" ");
        messagePanel.add(messageLabel);
        return messagePanel;
    }

    /**
     * Gets the entered username from the text field.
     *
     * @return The username entered by the user.
     */
    public String getUsername() {
        try {
            return username.getText();
        } catch (NullPointerException e) {
            messageLabel.setText("Please fill in the username field");
            return null;
        }
    }

    /**
     * Gets the entered password from the password field.
     *
     * @return The password entered by the user.
     */
    public String getPassword() {
        try {
            return new String(password.getPassword());
        } catch (NullPointerException e) {
            messageLabel.setText("Please fill in the password field");
            return null;
        }
    }

    /**
     * Adds an ActionListener for the login button.
     *
     * @param al The ActionListener to be added for the login button.
     */
    public void addLoginListener(ActionListener al) {
        loginBtn.addActionListener(al);
    }

    /**
     * Adds an ActionListener for the register button.
     *
     * @param al The ActionListener to be added for the register button.
     */
    public void addRegisterListener(ActionListener al) {
        registerBtn.addActionListener(al);
    }

    /**
     * Adds an ActionListener for the back button.
     *
     * @param al The ActionListener to be added for the back button.
     */
    public void addBackListener(ActionListener al) {
        backBtn.addActionListener(al);
    }

    /**
     * Adds the register button to the view.
     */
    public void addRegisterButton() {
        btnPanel.add(registerBtn);
    }
}
