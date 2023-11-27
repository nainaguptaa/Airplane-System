package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Map;
import java.util.ArrayList;

public class PassengerView extends JPanel {
    private JTable passengerTable;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    public PassengerView(Map<String, Integer> usersAndSeats, Map<String, ArrayList<String>> usersAndNames) {
        setSize(600, 400);
        setLayout(null);

        JLabel lbl = new JLabel("Passengers");
        lbl.setBounds(250, 10, 100, 30);
        add(lbl);

        // Define column names
        String[] columnNames = { "Username", "First Name", "Last Name", "Seat" };

        // Initialize the table model and set column names
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        loadPassengers(usersAndSeats, usersAndNames);

        passengerTable = new JTable(tableModel);

        scrollPane = new JScrollPane(passengerTable);
        scrollPane.setBounds(50, 50, 500, 300);
        add(scrollPane);
    }

    private void loadPassengers(Map<String, Integer> usersAndSeats, Map<String, ArrayList<String>> usersAndNames) {
        // for (int i = 0; i < flightViewModel.length; i++) {
        // tableModel.addRow(new Object[] { flightViewModel[i].FlightNumber,
        // flightViewModel[i].DepartureTime,
        // flightViewModel[i].ArrivalTime, flightViewModel[i].Price,
        // flightViewModel[i].Departure, flightViewModel[i].Destination });
        // }
        for (Map.Entry<String, ArrayList<String>> entry : usersAndNames.entrySet()) {
            tableModel.addRow(new Object[] { entry.getKey(), entry.getValue().get(0), entry.getValue().get(1),
                    usersAndSeats.get(entry.getKey()) });
        }
    }
}
