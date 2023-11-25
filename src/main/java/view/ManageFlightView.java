package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.flight.Flight;

public class ManageFlightView extends JPanel {
    private JTextField aircraftTextField;
    private JTextField originTextField;
    private JTextField destinationTextField;
    private JTextField departureTimeTextField;
    private JTextField arrivalTimeTextField;
    private JTextField priceTextField;
    private JButton submitBtn;

    public ManageFlightView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Aircraft Field
        add(new JLabel("Aircraft:"), gbc);
        aircraftTextField = new JTextField(20);
        add(aircraftTextField, gbc);

        // Origin Field
        add(new JLabel("Origin:"), gbc);
        originTextField = new JTextField(20);
        add(originTextField, gbc);

        // Destination Field
        add(new JLabel("Destination:"), gbc);
        destinationTextField = new JTextField(20);
        add(destinationTextField, gbc);

        // Departure Time Field
        add(new JLabel("Departure Time:"), gbc);
        departureTimeTextField = new JTextField(20);
        add(departureTimeTextField, gbc);

        // Arrival Time Field
        add(new JLabel("Arrival Time:"), gbc);
        arrivalTimeTextField = new JTextField(20);
        add(arrivalTimeTextField, gbc);

        // Price Field
        add(new JLabel("Price:"), gbc);
        priceTextField = new JTextField(20);
        add(priceTextField, gbc);

        // Submit Button
        submitBtn = new JButton("Submit");
        add(submitBtn, gbc);
    }

    // Getters for each field
    public String getAircraft() {
        return aircraftTextField.getText();
    }

    public String getOrigin() {
        return originTextField.getText();
    }

    public String getDestination() {
        return destinationTextField.getText();
    }

    public String getDepartureTime() {
        return departureTimeTextField.getText();
    }

    public String getArrivalTime() {
        return arrivalTimeTextField.getText();
    }

    public String getPrice() {
        return priceTextField.getText();
    }

    // Add submit button listener
    public void addSubmitButtonListener(ActionListener al) {
        submitBtn.addActionListener(al);
    }

    public void updateView(Flight model){
        aircraftTextField.setText(model.getAircraftId() + "");
        originTextField.setText(model.getOriginId() + "");
        destinationTextField.setText(model.getDestinationId() + "");
        departureTimeTextField.setText(model.getDepartureTime());
        arrivalTimeTextField.setText(model.getArrivalTime());
        priceTextField.setText(model.getPrice() + "");
    }
}
