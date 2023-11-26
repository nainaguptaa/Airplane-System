package view;

import model.flight.SeatType;
import viewModel.SeatViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SeatView extends JPanel {
    private static final int ROW_COUNT = 11;
    private static final int COLUMN_COUNT = 6;
    private static final Color COLOR_SELECTED = Color.GRAY;
    private static final Color COLOR_HOVER = Color.GRAY;
    private static final Color COLOR_BUSINESS = Color.RED;
    private static final Color COLOR_COMFORT = Color.ORANGE;
    private static final Color COLOR_ORDINARY = Color.GREEN;

    private SeatButton selectedSeatButton = null;

    private ArrayList<SeatViewModel> seatViewModels;

    public SeatView(ArrayList<SeatViewModel> svm) {
        this.seatViewModels = svm; // Assign the passed ArrayList
        setLayout(new BorderLayout());
        add(createLegendPanel(), BorderLayout.NORTH); // Legend panel
        add(createSeatMapPanel(), BorderLayout.CENTER); // Seat map panel

        setLayout(new GridBagLayout()); // Use GridBagLayout to center the SeatView

        // Constraints for the SeatView panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE; // Do not resize the SeatView panel

        add(this, gbc); // Add SeatView panel to the frame with constraints
        setSize(new Dimension(500, 700)); // Set the window size
        setVisible(true);
    }

    private JPanel createSeatMapPanel() {
        JPanel seatMapPanel = new JPanel();
        seatMapPanel.setLayout(new BorderLayout());
        seatMapPanel.add(createRowHeaders(), BorderLayout.WEST);
        seatMapPanel.add(createColumnHeaders(), BorderLayout.NORTH);

        JPanel seatsPanel = new JPanel(new GridLayout(ROW_COUNT, 1));
        for (int row = 0; row < ROW_COUNT; row++) {
            seatsPanel.add(createRowOfSeats(row));
        }
        seatMapPanel.add(seatsPanel, BorderLayout.CENTER);

        return seatMapPanel;
    }

    private JPanel createRowOfSeats(int rowNumber) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        for (int col = 0; col < COLUMN_COUNT; col++) {
            if (col == COLUMN_COUNT / 2) { // Create aisle space
                rowPanel.add(Box.createHorizontalStrut(30));
            }
            int index = rowNumber * COLUMN_COUNT + col;
            if (index < seatViewModels.size()) {
                SeatViewModel viewModel = seatViewModels.get(index);
                rowPanel.add(new SeatButton(viewModel));
            }
        }

        return rowPanel;
    }

    private JPanel createRowHeaders() {
        JPanel rowHeaders = new JPanel(new GridLayout(ROW_COUNT, 1));
        for (int i = 0; i < ROW_COUNT; i++) {
            rowHeaders.add(new JLabel(String.valueOf(i), SwingConstants.CENTER));
        }
        return rowHeaders;
    }

    private JPanel createColumnHeaders() {
        JPanel columnHeaders = new JPanel(new GridLayout(1, COLUMN_COUNT));
        for (int i = 0; i < COLUMN_COUNT; i++) {
            char columnLetter = (char) ('A' + i);
            columnHeaders.add(new JLabel(String.valueOf(columnLetter), SwingConstants.CENTER));
        }
        return columnHeaders;
    }

    private JPanel createLegendPanel() {
        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(new BoxLayout(legendPanel, BoxLayout.LINE_AXIS));
        legendPanel.add(Box.createHorizontalGlue());
        legendPanel.add(new LegendItem(COLOR_BUSINESS, "Business"));
        legendPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        legendPanel.add(new LegendItem(COLOR_COMFORT, "Comfort"));
        legendPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        legendPanel.add(new LegendItem(COLOR_ORDINARY, "Ordinary"));
        legendPanel.add(Box.createHorizontalGlue());
        return legendPanel;
    }

    private class LegendItem extends JPanel {
        public LegendItem(Color color, String text) {
            setBackground(color);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(new JLabel(text));
            setPreferredSize(new Dimension(100, 30));
        }
    }

    private class SeatButton extends JButton {
        SeatViewModel viewModel;

        SeatButton(SeatViewModel viewModel) {
            this.viewModel = viewModel;
            setText(viewModel.getSeatID() + " $" + getPriceByType(viewModel.getSeatType()));
            setColorByType(viewModel.getSeatType());
            setPreferredSize(new Dimension(95, 50)); // Adjusted button size
            setEnabled(viewModel.getAvailability()); // Disable the button if the seat is not available
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (selectedSeatButton != null && selectedSeatButton != SeatButton.this) {
                        selectedSeatButton.resetToOriginalState();
                    }
                    selectedSeatButton = SeatButton.this;
                    setBackground(COLOR_SELECTED);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (selectedSeatButton != SeatButton.this) {
                        setBackground(COLOR_HOVER);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (selectedSeatButton != SeatButton.this) {
                        setColorByType(viewModel.getSeatType());
                    }
                }
            });
        }

        void resetToOriginalState() {
            setColorByType(viewModel.getSeatType());
        }

        private void setColorByType(SeatType type) {
            switch (type) {
                case BUSINESS:
                    setBackground(Color.RED);
                    break;
                case COMFORT:
                    setBackground(Color.ORANGE);
                    break;
                case ORDINARY:
                    setBackground(Color.GREEN);
                    break;
            }
        }

        private float getPriceByType(SeatType type) {
            // Placeholder prices for seat types
            switch (type) {
                case BUSINESS:
                    return 50.0f;
                case COMFORT:
                    return 35.0f;
                case ORDINARY:
                    return 20.0f;
                default:
                    return 0.0f;
            }
        }
    }

    public void display(SeatView view) {
        JFrame frame = new JFrame("Seat View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout()); // Use GridBagLayout to center the SeatView

        // Constraints for the SeatView panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.NONE; // Do not resize the SeatView panel

        frame.add(view, gbc); // Add SeatView panel to the frame with constraints
        frame.setSize(new Dimension(500, 700)); // Set the window size
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}
