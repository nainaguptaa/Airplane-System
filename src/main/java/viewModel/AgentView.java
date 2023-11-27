package viewModel;

import viewModel.FlightViewModel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import view.FlightView;

public class AgentView extends JPanel {

    private FlightView flights;

    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;

    public AgentView(FlightViewModel fvm[]) {
        flights = new FlightView(fvm);

    }

}
