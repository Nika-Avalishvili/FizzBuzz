package com.example.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class FizzBuzzApplication {

    public static void main(String[] args) {
        SpringApplication.run(FizzBuzzApplication.class, args);

    }

//  Calculates using intermediate Greeting class
    @GetMapping("/")
    public Greeting index(){
        return new Greeting("nika", 130);
    }

//  Directly calculates and returns result
//  New line of comments for git testing
    @GetMapping("/FizzBuzz")
    public String hi(@RequestParam(value = "param1") String name,@RequestParam(value = "param2") int number){
        String result = "";
        if (number%3==0){
            result += "Fizz";
        }
        if (number%5==0){
            result += "Buzz";
        }
        return "Hello " + name +"!" +" Your result is: "+ result;
    }



}
