package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.flight.Flight;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ManageFlightView extends JPanel {
    private JComboBox<String> aircraftComboBox;
    private JComboBox<String> originComboBox;
    private JComboBox<String> destinationComboBox;
    private DateTimePicker departureDatePicker;
    private DateTimePicker arrivalDatePicker;
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

        // Aircraft Dropdown
        add(new JLabel("Aircraft:"), gbc);
        aircraftComboBox = new JComboBox<>();
        add(aircraftComboBox, gbc);

        // Origin Dropdown
        add(new JLabel("Origin:"), gbc);
        originComboBox = new JComboBox<>();
        add(originComboBox, gbc);

        // Destination Dropdown
        add(new JLabel("Destination:"), gbc);
        destinationComboBox = new JComboBox<>();
        add(destinationComboBox, gbc);

        DatePickerSettings departureSettings = new DatePickerSettings();
        departureSettings.setFormatForDatesCommonEra(DateTimeFormatter.ISO_LOCAL_DATE); // set your desired format
        departureDatePicker = new DateTimePicker();
        add(new JLabel("Departure Time:"), gbc);
        add(departureDatePicker, gbc);

        // Arrival Date Picker
        DatePickerSettings arrivalSettings = new DatePickerSettings();
        arrivalSettings.setFormatForDatesCommonEra(DateTimeFormatter.ISO_LOCAL_DATE); // set your desired format
        arrivalDatePicker = new DateTimePicker();
        add(new JLabel("Arrival Time:"), gbc);
        add(arrivalDatePicker, gbc);

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
        return aircraftComboBox.getSelectedItem().toString();
    }

    public String getOrigin() {
        return originComboBox.getSelectedItem().toString();
    }

    public String getDestination() {
        return destinationComboBox.getSelectedItem().toString();
    }

    // Update getters for departure and arrival time
    public LocalDateTime getDepartureTime() {
        return departureDatePicker.getDateTimeStrict(); // Adjust format as needed
    }

    public LocalDateTime getArrivalTime() {
        return arrivalDatePicker.getDateTimeStrict(); // Adjust format as needed
    }

    public String getPrice() {
        return priceTextField.getText();
    }

    // Add submit button listener
    public void addSubmitButtonListener(ActionListener al) {
        submitBtn.addActionListener(al);
    }

    public void addErrorMessage(String message){
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void addSuccessMessage(){
        JOptionPane.showMessageDialog(this, "Flight successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateView(Flight model){
        aircraftComboBox.setSelectedItem(model.getAircraftId() + "");
        originComboBox.setSelectedItem(model.getOriginId() + "");
        destinationComboBox.setSelectedItem(model.getDestinationId() + "");
        departureDatePicker.setDateTimeStrict(model.getDepartureLocalDateTime());
        arrivalDatePicker.setDateTimeStrict(model.getArrivalLocalDateTime());
        priceTextField.setText(model.getPrice() + "");
    }

    public void addAircraftDropdownItem(String item) {
        aircraftComboBox.addItem(item);
    }

    public void addOriginDropdownItem(String item) {
        originComboBox.addItem(item);
    }

    public void addDestinationDropdownItem(String item) {
        destinationComboBox.addItem(item);
    }
}
