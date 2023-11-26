package view;

import model.util.Promotion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPromotionView extends JPanel {
    private JTable promotionsTable;
    private DefaultTableModel tableModel;
    private JButton addButton;
    private JButton removeButton;
    private Promotion[] promotions;

    private JScrollPane scrollPane;


    public AdminPromotionView(Promotion[] promotions) {
        this.promotions = promotions;
        setSize(600, 400);
        setLayout(null);

        JLabel lbl = new JLabel("Flights");
        lbl.setBounds(250, 10, 100, 30);
        add(lbl);

        // Define column names
        String[] columnNames = { "PromotionId", "Discount", "Price After Discount" };

        // Initialize the table model and set column names
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        loadPromotions();

        promotionsTable = new JTable(tableModel);

        // Mouse listener for row selection
//        promotionsTable.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() == 1) {
//                    int row = promotionsTable.getSelectedRow();
//                    if (promotionsTable != null) {
//                        promotionsTable.actionPerformed(
//                                new ActionEvent(promotionsTable, ActionEvent.ACTION_PERFORMED, String.valueOf(row)));
//                    }
//                }
//            }
//        });

        scrollPane = new JScrollPane(promotionsTable);
        scrollPane.setBounds(50, 50, 500, 300);
        add(scrollPane);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public int getSelectedPromotionId() {
        int selectedRow = promotionsTable.getSelectedRow();
        return selectedRow != -1 ? (int) tableModel.getValueAt(selectedRow, 0) : -1;
    }

    private void loadPromotions() {
        for (Promotion promotion : promotions) {
            tableModel.addRow(new Object[]{promotion.getPromotionId(), promotion.getDiscount(),
                    promotion.getPriceForDiscount()});
        }
    }
}
