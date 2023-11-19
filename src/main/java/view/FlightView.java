package main.java.view;

import javax.swing.*;

public class FlightView extends JFrame {

    public FlightView() {
        setTitle("Flights");
        getContentPane().setLayout(null);
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JLabel lbl = new JLabel("Flights");
        lbl.setBounds(200, 50, 100, 30);

    }
}
