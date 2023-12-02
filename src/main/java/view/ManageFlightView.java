package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.flight.Flight;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * The ManageFlightView class represents the view for managing flight details.
 */
public class ManageFlightView extends JPanel {
    private JComboBox<String> aircraftComboBox;
    private JComboBox<String> originComboBox;
    private JComboBox<String> destinationComboBox;
    private DateTimePicker departureDatePicker;
    private DateTimePicker arrivalDatePicker;
    private JTextField priceTextField;
    private JButton submitBtn;

    /**
     * Constructs a new ManageFlightView.
     */
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

        // Departure Date Picker
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

    /**
     * Gets the selected aircraft from the dropdown.
     *
     * @return The selected aircraft.
     */
    public String getAircraft() {
        return aircraftComboBox.getSelectedItem().toString();
    }

    /**
     * Gets the selected origin from the dropdown.
     *
     * @return The selected origin.
     */
    public String getOrigin() {
        return originComboBox.getSelectedItem().toString();
    }

    /**
     * Gets the selected destination from the dropdown.
     *
     * @return The selected destination.
     */
    public String getDestination() {
        return destinationComboBox.getSelectedItem().toString();
    }

    /**
     * Gets the selected departure time from the date picker.
     *
     * @return The selected departure time.
     */
    public LocalDateTime getDepartureTime() {
        return departureDatePicker.getDateTimeStrict(); // Adjust format as needed
    }

    /**
     * Gets the selected arrival time from the date picker.
     *
     * @return The selected arrival time.
     */
    public LocalDateTime getArrivalTime() {
        return arrivalDatePicker.getDateTimeStrict(); // Adjust format as needed
    }

    /**
     * Gets the price entered in the text field.
     *
     * @return The entered price.
     */
    public String getPrice() {
        return priceTextField.getText();
    }

    /**
     * Adds an ActionListener for the submit button.
     *
     * @param al The ActionListener to be added for the submit button.
     */
    public void addSubmitButtonListener(ActionListener al) {
        submitBtn.addActionListener(al);
    }

    /**
     * Displays an error message dialog.
     *
     * @param message The error message to be displayed.
     */
    public void addErrorMessage(String message){
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a success message dialog for flight submission.
     */
    public void addSuccessMessage(){
        JOptionPane.showMessageDialog(this, "Flight successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Updates the view with flight data.
     *
     * @param model The Flight model to update the view with.
     */
    public void updateView(Flight model){
        aircraftComboBox.setSelectedItem(model.getAircraftId() + "");
        originComboBox.setSelectedItem(model.getOriginId() + "");
        destinationComboBox.setSelectedItem(model.getDestinationId() + "");
        departureDatePicker.setDateTimeStrict(model.getDepartureLocalDateTime());
        arrivalDatePicker.setDateTimeStrict(model.getArrivalLocalDateTime());
        priceTextField.setText(model.getPrice() + "");
    }

    /**
     * Adds an item to the aircraft dropdown.
     *
     * @param item The item to be added to the aircraft dropdown.
     */
    public void addAircraftDropdownItem(String item) {
        aircraftComboBox.addItem(item);
    }

    /**
     * Adds an item to the origin dropdown.
     *
     * @param item The item to be added to the origin dropdown.
     */
    public void addOriginDropdownItem(String item) {
        originComboBox.addItem(item);
    }

    /**
     * Adds an item to the destination dropdown.
     *
     * @param item The item to be added to the destination dropdown.
     */
    public void addDestinationDropdownItem(String item) {
        destinationComboBox.addItem(item);
    }
}
