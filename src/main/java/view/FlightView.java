package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ViewModel.FlightViewModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The FlightView class represents a view for displaying a list of flights.
 */
public class FlightView extends JPanel {

    private JTable flightTable;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private ActionListener flightSelectionListener;
    private FlightViewModel flightViewModel[];

    /**
     * Creates a new FlightView with the provided flight view models.
     *
     * @param fvm An array of FlightViewModel objects representing flight data.
     */
    public FlightView(FlightViewModel fvm[]) {
        flightViewModel = fvm;

        setSize(600, 400);
        setLayout(null);

        JLabel lbl = new JLabel("Flights");
        lbl.setBounds(250, 10, 100, 30);
        add(lbl);

        // Define column names for the flight table
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
     * Sets an ActionListener to handle flight selection events.
     *
     * @param listener The ActionListener to be added for flight selection events.
     */
    public void addFlightSelectionListener(ActionListener listener) {
        this.flightSelectionListener = listener;
    }

    /**
     * Loads flight data into the table model.
     */
    private void loadFlights() {
        for (FlightViewModel viewModel : flightViewModel) {
            tableModel.addRow(new Object[]{viewModel.FlightNumber, viewModel.DepartureTime,
                    viewModel.ArrivalTime, viewModel.Price,
                    viewModel.Departure, viewModel.Destination});
        }
    }
}
