package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection con = null;

    static {
        final String CONNECTION_STRING = "jdbc:h2:~/test";
        final String DB_USER_NAME = "sa";
        final String DB_PASSWORD = "";
        try {
            con = DriverManager.getConnection(CONNECTION_STRING, DB_USER_NAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }
}