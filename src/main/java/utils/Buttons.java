package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Buttons {
    public static JButton createStyledButton(String text, String actionCommand, Dimension size, Color color,
            Font font, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setActionCommand(actionCommand);
        button.addActionListener(actionListener); // Attach passed ActionListener
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        button.setMinimumSize(size);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(font);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }

    public static JButton createStyledButton(String text, String actionCommand, Dimension size, Color color,
            Font font) {
        JButton button = new JButton(text);
        button.setActionCommand(actionCommand);
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        button.setMinimumSize(size);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(font);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }

}
