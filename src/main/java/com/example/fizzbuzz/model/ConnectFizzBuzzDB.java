package com.example.fizzbuzz.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectFizzBuzzDB {
    public Connection get_connection() {
        Connection connection = null;
        String host = "localhost";
        String port = "5432";
        String db_name = "fizz_buzzdb";
        String username = "postgres";
        String password = "#REF!123";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FizzBuzz", "postgres", "#REF!123");

            if (connection != null) {
                System.out.println("Connection OK!");
            } else {
                System.out.println("Connection Failed!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

}
