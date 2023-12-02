package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ViewModel.FlightViewModel;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

/**
 * The AdminFlightView class represents the view for displaying flight information in an admin interface.
 */
public class AdminFlightView extends JPanel {

    private JTable flightTable;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private ActionListener flightSelectionListener;
    private FlightViewModel flightViewModel[];
    private DatePicker departureDateSearch;
    private JButton searchButton;

    /**
     * Creates a new AdminFlightView with the provided FlightViewModel array.
     * @param fvm An array of FlightViewModel objects representing flight data.
     */
    public AdminFlightView(FlightViewModel fvm[]) {
        flightViewModel = fvm;

        setSize(600, 450); // Increased height to accommodate new components
        setLayout(null);

        JLabel lbl = new JLabel("Flights");
        lbl.setBounds(250, 10, 100, 30);
        add(lbl);

        // Departure Date Search
        DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra("yyyy-MM-dd"); // Example format, modify as needed
        departureDateSearch = new DatePicker(dateSettings);
        departureDateSearch.setBounds(50, 360, 150, 30);
        add(departureDateSearch);

        // Search Button
        searchButton = new JButton("Search");
        searchButton.setBounds(210, 360, 100, 30);
        add(searchButton);

        // Define column names
        String[] columnNames = { "Flight Number", "Departure Time", "Arrival Time", "Price", "Departure", "Destination" };

        // Initialize the table model and set column names
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        loadFlights();

        flightTable = new JTable(tableModel);

        // Mouse listener for row selection
        flightTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int row = flightTable.getSelectedRow();
                    if (flightSelectionListener != null) {
                        flightSelectionListener.actionPerformed(
                                new ActionEvent(flightTable, ActionEvent.ACTION_PERFORMED, String.valueOf(row)));
                    }
                }
            }
        });

        scrollPane = new JScrollPane(flightTable);
        scrollPane.setBounds(50, 50, 500, 300);
        add(scrollPane);
    }

    /**
     * Adds a listener for flight selection events.
     * @param listener An ActionListener to be notified when a flight is selected.
     */
    public void addFlightSelectionListener(ActionListener listener) {
        this.flightSelectionListener = listener;
    }

    /**
     * Adds a listener for the search button.
     * @param listener An ActionListener to be notified when the search button is clicked.
     */
    public void addSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    /**
     * Gets the selected departure date for searching flights.
     * @return The selected departure date.
     */
    public LocalDate getDepartureDateSearch() {
        return departureDateSearch.getDate();
    }

    /**
     * Loads flight data into the table.
     */
    private void loadFlights() {
        for (int i = 0; i < flightViewModel.length; i++) {
            tableModel.addRow(new Object[] { flightViewModel[i].FlightNumber, flightViewModel[i].DepartureTime,
                    flightViewModel[i].ArrivalTime, flightViewModel[i].Price,
                    flightViewModel[i].Departure, flightViewModel[i].Destination });
        }
    }

    /**
     * Updates the table with new FlightViewModel data.
     * @param flightViewModel An array of FlightViewModel objects to update the table with.
     */
    public void updateTable(FlightViewModel[] flightViewModel) {
        tableModel.setRowCount(0);
        this.flightViewModel = flightViewModel;
        loadFlights();
    }
}
