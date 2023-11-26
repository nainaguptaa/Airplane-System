package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Setup Decorator Pattern
public class LoginView extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JButton loginBtn;
    private JButton registerBtn;
    private JButton backBtn;
    private JLabel messageLabel; // Label to display messages

    public LoginView() {
        // setTitle("Login");
        setSize(450, 300);
        setBackground(new Color(230, 230, 250));

        // Using BorderLayout for overall layout
        setLayout(new BorderLayout(10, 10));
        add(createFormPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
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
        buttonPanel.add(registerBtn);

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

    public String getUsername() {
        try {
            return username.getText();
        } catch (NullPointerException e) {
            messageLabel.setText("Please fill in password field");
            throw e;
        }
    }

    public String getPassword() {
        try {
            System.out.println(password.getPassword());
            return new String(password.getPassword());
        } catch (NullPointerException e) {
            messageLabel.setText("Please fill in password field");
            throw e;
        }
    }

    public void addLoginListener(ActionListener al) {
        loginBtn.addActionListener(al);
    }

    public void addRegisterListener(ActionListener al) {
        registerBtn.addActionListener(al);
    }

    public void addBackListener(ActionListener al) {
        backBtn.addActionListener(al);
    }

    public void display() {
        System.out.println("Login Form:");
        // Code to display login form (username and password fields)
    }
}