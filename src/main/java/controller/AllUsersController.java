package controller;

import view.AllUsersView;

import java.awt.event.*;
import java.sql.ResultSet;
import model.role.User;

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
        String query = "SELECT username, first_name, last_name, address, email, role, member FROM users";

        ResultSet rs = db.executeQuery(query);
        try{
            while(rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                int role = rs.getInt("role");
                Boolean member = rs.getBoolean("member");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String address = rs.getString("address");
    
                String[] userData = {username, firstName, lastName, address, email, User.roleToString(role), member.toString()};
                allUsersView.addUser(userData);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
