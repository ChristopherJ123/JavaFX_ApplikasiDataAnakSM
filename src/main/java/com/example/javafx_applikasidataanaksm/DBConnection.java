package com.example.javafx_applikasidataanaksm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public static Connection dbLink;

    public static Connection getConnection() {
        String dbName = "AplikasiDataAnakSM2";
        String dbUser = "postgres";
        String dbPass = "admin";
        String url = "jdbc:postgresql://localhost:5432/" + dbName;
        try {
            dbLink = DriverManager.getConnection(url, dbUser, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbLink;
    }

    public static Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    public static void main(String[] args) {
        getConnection();
    }
}
