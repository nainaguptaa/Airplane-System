package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeatView extends JPanel {

    private static final Dimension BUTTON_SIZE = new Dimension(40, 40); // Smaller button size

    public SeatView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Using BoxLayout for vertical stacking
        setPreferredSize(new Dimension(500, 400)); // Smaller panel size

        // Add different class sections
        add(createBusinessClassSection());
        add(Box.createVerticalStrut(10)); // Spacer between sections
        add(createEconomyClassSection());
    }

    private JPanel createBusinessClassSection() {
        JPanel businessClass = new JPanel(new GridLayout(2, 4, 5, 5)); // Fewer rows, space between seats
        for (int i = 0; i < 8; i++) {
            JButton seat = createSeatButton("B" + (i + 1), Color.GREEN); // Business class seats
            businessClass.add(seat);
        }
        return businessClass;
    }

    private JPanel createEconomyClassSection() {
        JPanel economyClass = new JPanel(new GridLayout(5, 6, 5, 5)); // More rows, space between seats
        for (int i = 0; i < 30; i++) {
            JButton seat = createSeatButton("E" + (i + 1), Color.BLUE); // Economy class seats
            economyClass.add(seat);
        }
        return economyClass;
    }

    private JButton createSeatButton(String seatID, Color color) {
        JButton button = new JButton(seatID);
        button.setPreferredSize(BUTTON_SIZE);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false); // Remove focus ring for aesthetics
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (button.getBackground() != Color.LIGHT_GRAY) {
                    button.setBackground(Color.CYAN);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (button.getBackground() != Color.LIGHT_GRAY) {
                    button.setBackground(color);
                }
            }
        });
        return button;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Airplane Seats View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SeatView seatsView = new SeatView();
        frame.add(seatsView);
        frame.pack(); // Adjust frame to fit the panel
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}
