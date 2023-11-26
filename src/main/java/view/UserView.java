package  view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.role.User;
import utils.Buttons;

public class UserView extends JPanel {
    private JLabel usernameLabel;
    private JLabel emailLabel;
    private JLabel roleLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel addressLabel;
    private JButton bookingsButton;
    private JButton logoutButton;

    public UserView(int role) {
        setBackground(new Color(240, 248, 255));
        setLayout(new GridBagLayout());  // Updated to GridBagLayout for centering

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 0, 5, 0);

        // Header Panel
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, gbc);

        // Spacing
        add(Box.createRigidArea(new Dimension(0, 20)), gbc);
        // Bookings Button
        bookingsButton = Buttons.createStyledButton(
            "Go To Bookings",
            "BookingsView",
            new Dimension(180, 40),
            new Color(100, 181, 246),
            new Font("Arial", Font.BOLD, 14));
        if (role == 2){
            add(bookingsButton, gbc);
        }
        
        logoutButton = Buttons.createStyledButton(
            "Logout",
            "Logout",
            new Dimension(180, 40),
            new Color(100, 181, 246),
            new Font("Arial", Font.BOLD, 14));    
        
        add(logoutButton, gbc);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        headerPanel.setBackground(getBackground());
        // Username
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        headerPanel.add(usernameLabel);

        // First Name
        firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        headerPanel.add(firstNameLabel);

        // Last Name
        lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        headerPanel.add(lastNameLabel);

        // Address
        addressLabel = new JLabel("Address: ");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        headerPanel.add(addressLabel);

        // Email
        emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        headerPanel.add(emailLabel);

        // Role
        roleLabel = new JLabel("Role: ");
        roleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
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

    public void setFirstName(String firstName) {
        firstNameLabel.setText("First Name: " + firstName);
    }

    public void setLastName(String lastName) {
        lastNameLabel.setText("Last Name: " + lastName);
    }

    public void setAddress(String address) {
        addressLabel.setText("Address: " + address);
    }

    public void addBookingsButtonListener(ActionListener al) {
        bookingsButton.addActionListener(al);
    }

    public void addLogoutButtonListener(ActionListener al) {
        logoutButton.addActionListener(al);
    }

    public void updateView(User data) {
        setUsername(data.getUsername());
        setEmail(data.getEmail());
        setRole(User.roleToString(data.getRole()));
        setFirstName(data.getFirstName());
        setLastName(data.getLastName());
        setAddress(data.getAddress());
    }
}
