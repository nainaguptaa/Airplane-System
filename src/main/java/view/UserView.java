package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.role.User;
import utils.Buttons;

/**
 * The UserView class represents the graphical user interface for displaying user information and actions.
 */
public class UserView extends JPanel {
    private JLabel usernameLabel;
    private JLabel emailLabel;
    private JLabel roleLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel addressLabel;
    private JButton bookingsButton;
    private JButton logoutButton;

    /**
     * Constructs a UserView with the specified user role.
     *
     * @param role The role of the user (e.g., admin, regular user).
     */
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

        // Logout Button
        logoutButton = Buttons.createStyledButton(
            "Logout",
            "Logout",
            new Dimension(180, 40),
            new Color(100, 181, 246),
            new Font("Arial", Font.BOLD, 14));
        add(logoutButton, gbc);
    }

    /**
     * Creates and returns a header panel containing user information labels.
     *
     * @return The JPanel containing user information labels.
     */
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        headerPanel.setBackground(getBackground());

        // Username Label
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        headerPanel.add(usernameLabel);

        // First Name Label
        firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        headerPanel.add(firstNameLabel);

        // Last Name Label
        lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        headerPanel.add(lastNameLabel);

        // Address Label
        addressLabel = new JLabel("Address: ");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        headerPanel.add(addressLabel);

        // Email Label
        emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        headerPanel.add(emailLabel);

        // Role Label
        roleLabel = new JLabel("Role: ");
        roleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        headerPanel.add(roleLabel);

        return headerPanel;
    }

    /**
     * Sets the username label text.
     *
     * @param username The username to display.
     */
    public void setUsername(String username) {
        usernameLabel.setText("Username: " + username);
    }

    /**
     * Sets the email label text.
     *
     * @param email The email to display.
     */
    public void setEmail(String email) {
        emailLabel.setText("Email: " + email);
    }

    /**
     * Sets the role label text.
     *
     * @param role The role to display.
     */
    public void setRole(String role) {
        roleLabel.setText("Role: " + role);
    }

    /**
     * Sets the first name label text.
     *
     * @param firstName The first name to display.
     */
    public void setFirstName(String firstName) {
        firstNameLabel.setText("First Name: " + firstName);
    }

    /**
     * Sets the last name label text.
     *
     * @param lastName The last name to display.
     */
    public void setLastName(String lastName) {
        lastNameLabel.setText("Last Name: " + lastName);
    }

    /**
     * Sets the address label text.
     *
     * @param address The address to display.
     */
    public void setAddress(String address) {
        addressLabel.setText("Address: " + address);
    }

    /**
     * Adds an ActionListener to the bookings button.
     *
     * @param al The ActionListener to be added.
     */
    public void addBookingsButtonListener(ActionListener al) {
        bookingsButton.addActionListener(al);
    }

    /**
     * Adds an ActionListener to the logout button.
     *
     * @param al The ActionListener to be added.
     */
    public void addLogoutButtonListener(ActionListener al) {
        logoutButton.addActionListener(al);
    }

    /**
     * Updates the view with user information.
     *
     * @param data The User object containing user information.
     */
    public void updateView(User data) {
        setUsername(data.getUsername());
        setEmail(data.getEmail());
        setRole(User.roleToString(data.getRole()));
        setFirstName(data.getFirstName());
        setLastName(data.getLastName());
        setAddress(data.getAddress());
    }
}
