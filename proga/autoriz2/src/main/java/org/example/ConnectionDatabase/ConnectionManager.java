package org.example.ConnectionDatabase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static Connection getConnection(){

        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/study",
                    "root", "12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
