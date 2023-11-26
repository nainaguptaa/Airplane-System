package controller;

import model.util.Promotion;
import view.AdminPromotionView;
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
        adminPromotionView.getAddButton().addActionListener(this);
        adminPromotionView.getRemoveButton().addActionListener(this);


    }

    private ArrayList<Promotion> getPromotions() {
        try {
            ResultSet rs = db.executeQuery("SELECT promotion_id, discount, price_after_discount FROM promotion");

            while(rs.next()) {
                promotions.add(new Promotion(rs.getInt("promotion_id"), rs.getDouble("discount"), rs.getDouble("price_after_discount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotions;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminPromotionView.getAddButton()) {
            db.executeUpdate("INSERT INTO promotion (discount, price_after_discount) VALUES (0, 0)");
            promotions = getPromotions();
        } else if (e.getSource() == adminPromotionView.getRemoveButton()) {
            int selectedId = adminPromotionView.getSelectedPromotionId();
            if (selectedId != -1) {
                db.executeUpdate("DELETE FROM promotion WHERE promotion_id = " + selectedId);
                promotions = getPromotions();
            }
        }
    }

    public AdminPromotionView getView() {
        return adminPromotionView;
    }

}

