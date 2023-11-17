package main.java.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
    private static Database instance;
    private String url;
    private String username;
    private String password;
    private Connection connection;

    private Database(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        connect();
    }

    public static Database getInstance(String url, String username, String password) {
        if (instance == null) {
            instance = new Database(url, username, password);
        }
        return instance;
    }

    private void connect() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

}
