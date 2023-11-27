package controller;

import model.util.Promotion;
import view.AdminPromotionView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminPromotionController implements ActionListener {
    private Database db;
    private MainController mainController;
    private AdminPromotionView adminPromotionView;

    private ArrayList<Promotion> promotions;

    public AdminPromotionController(Database db, MainController mc) {
        this.db = db;
        this.mainController = mc;


        promotions = new ArrayList<Promotion>();
        adminPromotionView = new AdminPromotionView(getPromotions().toArray(new Promotion[0]));

        adminPromotionView.getCreateButton().addActionListener(this);

        // Add property change listener for delete action
        adminPromotionView.addPropertyChangeListener("deletePromotion", evt -> {
            int row = (int) evt.getNewValue();
            deletePromotion(promotions.get(row));
            refreshPromotions();
        });


    }

    private ArrayList<Promotion> getPromotions() {
        try {
            ResultSet rs = db.executeQuery("SELECT promotion_id, discount, price_for_discount FROM promotion");

            while(rs.next()) {
                promotions.add(new Promotion(rs.getInt("promotion_id"), rs.getDouble("discount"), rs.getDouble("price_for_discount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotions;
    }

    private void deletePromotion(Promotion promotion) {
        db.executeUpdate("DELETE FROM promotion WHERE promotion_id = " + promotion.getPromotionId());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminPromotionView.getCreateButton()) {
            // Display dialog or another form to get new promotion data
            createNewPromotion();
        }
    }

    private void createNewPromotion() {
        // Create a panel to hold input fields
        JPanel panel = new JPanel(new GridLayout(0, 2));
        JTextField discountField = new JTextField();
        JTextField priceAfterDiscountField = new JTextField();

        panel.add(new JLabel("Discount:"));
        panel.add(discountField);
        panel.add(new JLabel("Price For Discount:"));
        panel.add(priceAfterDiscountField);

        // Show dialog with input fields
        int result = JOptionPane.showConfirmDialog(null, panel,
                "Create New Promotion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                double discount = Double.parseDouble(discountField.getText());
                double priceAfterDiscount = Double.parseDouble(priceAfterDiscountField.getText());

                // Add validation if necessary

                // Insert the new promotion into the database
                db.executeUpdate("INSERT INTO promotion (discount, price_for_discount) VALUES ("
                        + discount + ", " + priceAfterDiscount + ")");

                // Refresh promotions list
                refreshPromotions();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
            }
        }
    }


    private void refreshPromotions() {
        promotions = getPromotions();
        adminPromotionView.updateTableData(promotions.toArray(new Promotion[0]));
    }

    public AdminPromotionView getView() {
        return adminPromotionView;
    }

}

