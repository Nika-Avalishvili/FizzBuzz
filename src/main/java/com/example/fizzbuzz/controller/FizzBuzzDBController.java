package com.example.fizzbuzz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.fizzbuzz.fizzbuzzServices.FizzBuzzDBService.connectionAndExecute;
import static com.example.fizzbuzz.fizzbuzzServices.FizzBuzzResultService.setResult;

@RestController
public class FizzBuzzDBController {
    
    @GetMapping("/insertValue")
    public static void addValues(@RequestParam(value = "id") Long id, @RequestParam (value = "myNumber") Integer myNumber, @RequestParam (value = "name") String name) {
        String query = "INSERT INTO fizz_buzzdb (id, my_number, name, result) VALUES ( '" +id+"' , '" +myNumber+"' , '"+name+"', '"+ setResult(myNumber)+"')";
        connectionAndExecute(query);
        System.out.println("Value Inserted Successfully!");
    }

    @GetMapping("/updateValue")
    public static void updateValues(@RequestParam (value = "id") Long id, @RequestParam (value = "myNumber") Integer myNumber, @RequestParam (value = "name") String name) {
        String query = "UPDATE fizz_buzzdb SET  my_number='" +myNumber+"' , name='"+name+"', result='"+ setResult(myNumber)+"' WHERE id ='" +id+ "'";
        connectionAndExecute(query);
        System.out.println("Value Updated Successfully!");
    }

    @GetMapping("/deleteValue")
    public static void deleteValues(@RequestParam (value = "id") Long id) {
        String query = "DELETE FROM fizz_buzzdb WHERE id ='" +id+ "'";
        connectionAndExecute(query);
        System.out.println("Value Removed Successfully!");
    }

    @GetMapping("/createTable")
    public void createTable(@RequestParam(value = "tableName") String tbl_name, @RequestParam(value = "param1") String name1, @RequestParam(value = "param2") String name2) {
        String query = "CREATE TABLE IF NOT EXISTS "+tbl_name+" (id SERIAL PRIMARY KEY, "+name1+" VARCHAR(255), "+name2+" VARCHAR(255))";
        connectionAndExecute(query);
        System.out.println("Table Created Successfully!");
    }
}
