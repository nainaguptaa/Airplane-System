package view;

import ViewModel.PassengerViewModel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PassengerView extends JPanel {
    private JTable passengerTable;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    private PassengerViewModel[] passengerViewModels;

    public PassengerView(PassengerViewModel[] pvm) {

        this.passengerViewModels = pvm;

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

        loadPassengers();

        passengerTable = new JTable(tableModel);

        scrollPane = new JScrollPane(passengerTable);
        scrollPane.setBounds(50, 50, 500, 300);
        add(scrollPane);
    }

    private void loadPassengers() {
        for (PassengerViewModel entry : passengerViewModels) {
            tableModel.addRow(new Object[] { entry.getUserName(),
                    entry.getFirstName(),
                    entry.getLastName(),
                    entry.getSeat() });
        }
    }
}
