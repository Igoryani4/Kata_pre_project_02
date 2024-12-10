package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
    final static String URL = "jdbc:mysql://localhost:3306/newdbtest";
    final static String username = "root";
    final static String password = "";

    public static void main(String[] args) {
//        System.out.println("Loading driver ...");
        try {
            getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // Use com.mysql.jdbc.Driver if you're not on MySQL 8+ yet.
//            System.out.println("Driver loaded!");
//        } catch (ClassNotFoundException e) {
//            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
//        }
//
//        System.out.println("Connecting database ...");
//        try (Connection conn = DriverManager.getConnection(URL, username, password)) {
//            System.out.println("Database connected!");
//            Statement stmt = conn.createStatement();
//
//
//        } catch (SQLException e) {
//            throw new IllegalStateException("Cannot connect the database!", e);
//        }



    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Use com.mysql.jdbc.Driver if you're not on MySQL 8+ yet.
//            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        try {
            Connection ignored = DriverManager.getConnection(URL, username, password);
//            System.out.println("Database connected!");

            return ignored;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

    }




}
