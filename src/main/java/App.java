
import javax.swing.UIManager;

import controller.MainController;

public class App {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        MainController.getInstance();
    }
}
