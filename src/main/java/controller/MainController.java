package main.java.controller;

public class MainController {
    private Database db;
    private static MainController instance;
    private EntryController entryController;
    private LoginController loginController;
    private UserController userController;
    private FlightController flightController;

    private MainController() {
        this.db = Database.getInstance("jdbc:mysql://localhost:3306/airline", "root", "SagittariusA5290$");
        this.switchToView("FlightView");

    }

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    public void switchToLoginView(String role) {
        loginController = new LoginController(db, this, role);
    }

    public void switchToView(String viewName) {

        switch (viewName) {
            case "EntryView":
                entryController = new EntryController(db, this);
                break;

            case "GuestView":
                userController = new UserController(db, this);
                break;

            case "FlightView":
                flightController = new FlightController(db, this);
                break;

            default:
                break;
        }
    }
}
