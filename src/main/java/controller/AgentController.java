package controller;

import model.role.User;
import viewModel.AgentView;

public class AgentController {
    // include method for browsing passengers in a flight
    private Database db;
    private MainController mc;
    private User model;
    private AgentView view;

    public AgentController(Database db, MainController mc) {
        this.db = db;
        this.mc = mc;
        this.model = mc.getUser();
        this.view = new AgentView();
    }

}
