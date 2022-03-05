package com.se.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionDB {

    public ConnectionDB() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    protected Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/se", "root", "root");
    }

    protected void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
