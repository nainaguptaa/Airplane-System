package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This utility class provides methods for creating styled buttons in Swing applications.
 */
public class Buttons {
    /**
     * Creates a styled button with the specified attributes.
     *
     * @param text           The text displayed on the button.
     * @param actionCommand The action command associated with the button.
     * @param size           The preferred size of the button.
     * @param color          The background color of the button.
     * @param font           The font used for the button's text.
     * @param actionListener The ActionListener to be attached to the button.
     * @return A JButton with the specified styling and attributes.
     */
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

    /**
     * Creates a styled button with the specified attributes, excluding an ActionListener.
     *
     * @param text           The text displayed on the button.
     * @param actionCommand The action command associated with the button.
     * @param size           The preferred size of the button.
     * @param color          The background color of the button.
     * @param font           The font used for the button's text.
     * @return A JButton with the specified styling and attributes (without ActionListener).
     */
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
