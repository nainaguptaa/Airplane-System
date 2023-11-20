package main.java.controller;

import main.java.model.role.User;

public class MainController {
    private Database db;
    private static MainController instance;
    private EntryController entryController;
    private LoginController loginController;
    private UserController userController;
    private RegisterController registerController;
    private User user;

    private MainController() {
        this.db = Database.getInstance("jdbc:mysql://localhost:3306/airline", "root", "SagittariusA5290$");
        this.user = new User();
        this.switchToView("EntryView");

    }

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void switchToView(String viewName) {

        switch (viewName) {
            case "EntryView":
                entryController = new EntryController(db, this);
                break;

            case "GuestView":
                userController = new UserController(db, this);
                break;
            
            case "LoginView":
                loginController = new LoginController(db, this);
                break;

            case "RegisterView":
                registerController = new RegisterController(db, this);
                break;

            default:
                break;
        }
    }
}
