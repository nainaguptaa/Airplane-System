package controller;

import view.AllUsersView;

import java.awt.event.*;
import java.sql.ResultSet;

public class AllUsersController{
    Database db;
    MainController mainController;
    AllUsersView allUsersView;

    public AllUsersController(Database db, MainController mc) {
        this.db = db;
        this.mainController = mc;

        allUsersView = new AllUsersView();
        getUsers();
    }

    public AllUsersView getView() {
        return allUsersView;
    }

    private void getUsers() {
        String query = "SELECT username, email, role FROM users WHERE member = TRUE";

        ResultSet rs = db.executeQuery(query);
        try{
            while(rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String role = rs.getString("role");
    
                String[] userData = {username, email, role};
                allUsersView.addUser(userData);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
