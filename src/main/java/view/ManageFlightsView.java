package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import utils.Buttons;

public class ManageFlightsView extends JPanel {
    private JButton addFlightButton;
    private JButton removeFlightButton;
    private JButton changeFlightButton;
    private JTextField flightIDTextField;

    public ManageFlightsView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add Flight Button
        addFlightButton = Buttons.createStyledButton(
            "Add Flight",
            "Add",
            new Dimension(180, 40),
            new Color(100, 181, 246),
            new Font("Arial", Font.BOLD, 14));    

        addFlightButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addFlightButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(addFlightButton);

        flightIDTextField = new JTextField(20);
        flightIDTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        flightIDTextField.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(new JLabel("Flight ID:"));
        add(flightIDTextField);

        // Remove Flight Button
        removeFlightButton = Buttons.createStyledButton(            
            "Remove Flight",
            "Remove",
            new Dimension(180, 40),
            new Color(100, 181, 246),
            new Font("Arial", Font.BOLD, 14));    
        removeFlightButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeFlightButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(removeFlightButton);

        changeFlightButton = Buttons.createStyledButton(
            "Change Flight",
            "Change",
            new Dimension(180, 40),
            new Color(100, 181, 246),
            new Font("Arial", Font.BOLD, 14));    
        changeFlightButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        changeFlightButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(changeFlightButton);
    }

    public void addAddFlightButtonListener(ActionListener al) {
        addFlightButton.addActionListener(al);
    }

    public void addRemoveFlightButtonListener(ActionListener al) {
        removeFlightButton.addActionListener(al);
    }

    public void addChangeFlightButtonListener(ActionListener al) {
        changeFlightButton.addActionListener(al);
    }

    public String getFlightID() {
        return flightIDTextField.getText();
    }
}

