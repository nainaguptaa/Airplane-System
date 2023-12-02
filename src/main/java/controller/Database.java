package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * The Database class manages the database connection and provides methods
 * for executing SQL queries and updates.
 */
public class Database {
    private static Database instance;
    private String url;
    private String username;
    private String password;
    private Connection connection;

    /**
     * Constructs a Database instance and establishes a connection to the database.
     *
     * @param url      The URL of the database.
     * @param username The username for database access.
     * @param password The password for database access.
     */
    private Database(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        connect();
    }

    /**
     * Gets a singleton instance of the Database class.
     * If an instance does not exist, it creates one and establishes a connection to the database.
     *
     * @param url      The URL of the database.
     * @param username The username for database access.
     * @param password The password for database access.
     * @return The Database instance.
     */
    public static Database getInstance(String url, String username, String password) {
        if (instance == null) {
            instance = new Database(url, username, password);
        }
        return instance;
    }

    /**
     * Establishes a connection to the database.
     */
    private void connect() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Executes an SQL query and returns a ResultSet containing the query results.
     *
     * @param query The SQL query to be executed.
     * @return A ResultSet containing the query results, or null if an error occurs.
     */
    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Executes an SQL update statement (e.g., INSERT, UPDATE, DELETE).
     *
     * @param query The SQL update query to be executed.
     * @return The number of affected rows, or -1 if an error occurs.
     */
    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Gets the Connection object associated with the database connection.
     *
     * @return The Connection object.
     */
    public Connection getConnection() {
        return connection;
    }
}
