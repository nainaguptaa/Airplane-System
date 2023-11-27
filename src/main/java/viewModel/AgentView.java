package viewModel;

import viewModel.FlightViewModel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import view.FlightView;

public class AgentView {

    private FlightView flights;

    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;

    // Should I just use the flight view you guys already created or generate a
    // flights table again in this code
    //

    public AgentView(ArrayList<FlightViewModel> fvm) {
        FlightViewModel[] newFvm = (FlightViewModel[]) fvm.toArray();
        this.flights = new FlightView(newFvm);
    }
}
