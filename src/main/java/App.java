package main.java;

import javax.swing.UIManager;

import main.java.controller.MainController;

public class App {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        MainController.getInstance();
    }
}
