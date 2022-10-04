package com.example.fizzbuzz.fizzbuzzServices;

import com.example.fizzbuzz.model.ConnectFizzBuzzDB;
import java.sql.Connection;
import java.sql.Statement;

public class FizzBuzzDBService {
    public static void connectionAndExecute(String query){
        Connection connection = null;
        Statement statement = null;

        ConnectFizzBuzzDB objConnectFizzBuzzDB= new ConnectFizzBuzzDB();
        connection = objConnectFizzBuzzDB.get_connection();

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
