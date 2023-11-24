package  view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MembershipView extends JPanel {

    private JButton signUpButton;
    private JLabel membershipStatusLabel;
    private JList<String> promotionsList;

    public MembershipView() {
        setSize(450, 350);
        setBackground(new Color(230, 230, 250));
        setLayout(new BorderLayout(10, 10));

        // Membership status label
        membershipStatusLabel = new JLabel("Checking membership status...");
        add(membershipStatusLabel, BorderLayout.NORTH);

        // Sign-up button
        signUpButton = new JButton("Sign Up for Premium");
        signUpButton.setVisible(false); // Hidden initially
        add(signUpButton, BorderLayout.SOUTH);

        // Promotions list
        promotionsList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(promotionsList);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setMembershipStatus(boolean isPremiumMember) {
        if (isPremiumMember) {
            membershipStatusLabel.setText("You are a Premium Member!");
            signUpButton.setVisible(false);
            promotionsList.setVisible(true);
        } else {
            membershipStatusLabel.setText("You are not a Premium Member.");
            signUpButton.setVisible(true);
            promotionsList.setVisible(false);
        }
    }

    public void setPromotionsList(String[] promotions) {
        promotionsList.setListData(promotions);
    }

    public void addSignUpListener(ActionListener listener) {
        signUpButton.addActionListener(listener);
    }
}
