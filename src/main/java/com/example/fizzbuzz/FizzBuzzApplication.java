package com.example.fizzbuzz;

import com.example.fizzbuzz.model.ConnectFizzBuzzDB;
import com.example.fizzbuzz.repository.FizzBuzzRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.sql.*;

@SpringBootApplication
@RestController
public class FizzBuzzApplication {

    public static void main(String[] args) {
        SpringApplication.run(FizzBuzzApplication.class, args);
    }


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
    public static void addValues(@RequestParam (value = "id") Long id, @RequestParam (value = "myNumber") Integer myNumber, @RequestParam (value = "name") String name) {

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



}
