package com.example.fizzbuzz.controller;

import com.example.fizzbuzz.model.ConnectFizzBuzzDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.Statement;


@RestController
public class FizzBuzzDBController {

    public static String setResult(Integer myNumber, String result){
        if (myNumber % 3 == 0){
            result += "Fizz";
        }
        if (myNumber % 5 == 0){
            result += "Buzz";
        }
        return result;
    }


    @GetMapping("/insertValue")
    public static void addValues(@RequestParam(value = "id") Long id, @RequestParam (value = "myNumber") Integer myNumber, @RequestParam (value = "name") String name) {

        Connection connection = null;
        Statement statement = null;

        ConnectFizzBuzzDB objConnectFizzBuzzDB= new ConnectFizzBuzzDB();
        connection = objConnectFizzBuzzDB.get_connection();


        String result = "";
        result = setResult(myNumber, result);

        try {
            String query = "INSERT INTO fizz_buzzdb (id, my_number, name, result) VALUES ( '" +id+"' , '" +myNumber+"' , '"+name+"', '"+result+"')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Value Inserted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/updateValue")
    public static void updateValues(@RequestParam (value = "id") Long id, @RequestParam (value = "myNumber") Integer myNumber, @RequestParam (value = "name") String name) {

        Connection connection = null;
        Statement statement = null;

        ConnectFizzBuzzDB objConnectFizzBuzzDB= new ConnectFizzBuzzDB();
        connection = objConnectFizzBuzzDB.get_connection();

        String result = "";
        result = setResult(myNumber, result);

        try {
            String query = "UPDATE fizz_buzzdb SET  my_number='" +myNumber+"' , name='"+name+"', result='"+result+"' WHERE id ='" +id+ "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Value Updated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/deleteValue")
    public static void deleteValues(@RequestParam (value = "id") Long id) {

        Connection connection = null;
        Statement statement = null;

        ConnectFizzBuzzDB objConnectFizzBuzzDB= new ConnectFizzBuzzDB();
        connection = objConnectFizzBuzzDB.get_connection();

        try {
            String query = "DELETE FROM fizz_buzzdb WHERE id ='" +id+ "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Value Removed Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //    Test method used to test creation of new tables in PostgreSQL database;
    @GetMapping("/createTable")
    public void createTable(@RequestParam(value = "tableName") String tbl_name, @RequestParam(value = "param1") String name1, @RequestParam(value = "param2") String name2) {
        Connection connection = null;
        Statement statement = null;
        ConnectFizzBuzzDB objConnectFizzBuzzDB= new ConnectFizzBuzzDB();
        connection = objConnectFizzBuzzDB.get_connection();

        try {
            String query = "CREATE TABLE IF NOT EXISTS "+tbl_name+" (id SERIAL PRIMARY KEY, "+name1+" VARCHAR(255), "+name2+" VARCHAR(255))";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created Successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
