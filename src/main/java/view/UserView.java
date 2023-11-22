package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import main.java.model.role.User;

public class UserView extends JPanel {
    private JLabel usernameLabel;
    private JLabel emailLabel;
    private JLabel roleLabel;
    private JButton bookingsButton;

    public UserView() {
        setSize(500, 400);
        setBackground(new Color(240, 248, 255));
        setLayout(new BorderLayout(10, 10));

        // Header Panel
        add(createHeaderPanel(), BorderLayout.NORTH);

        // Bookings Button
        bookingsButton = new JButton("Go To Bookings");
        add(bookingsButton, BorderLayout.CENTER);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        // Username
        usernameLabel = new JLabel("Username: ");
        headerPanel.add(usernameLabel);

        // Email
        emailLabel = new JLabel("Email: ");
        headerPanel.add(emailLabel);

        // Role
        roleLabel = new JLabel("Role: ");
        headerPanel.add(roleLabel);

        return headerPanel;
    }

    public void setUsername(String username) {
        usernameLabel.setText("Username: " + username);
    }

    public void setEmail(String email) {
        emailLabel.setText("Email: " + email);
    }

    public void setRole(String role) {
        roleLabel.setText("Role: " + role);
    }

    public void addBookingsButtonListener(ActionListener al) {
        bookingsButton.addActionListener(al);
    }
    public void updateView(User data) {
        setUsername(data.getUsername());
        setEmail(data.getEmail());
        setRole(User.roleToString(data.getRole()));
    }
}
