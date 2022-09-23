package com.example.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class FizzBuzzApplication {

    public static void main(String[] args) {
        SpringApplication.run(FizzBuzzApplication.class, args);

    }

//  Calculates using intermediate Greeting class
    @GetMapping("/")
    public FizzBuzz index(){
        return new FizzBuzz("nika", 130);
    }

//  Directly calculates and returns result
//  New line of comments for git testing
    @GetMapping("/FizzBuzzPage")
    public String fizzBuzz(@RequestParam(value = "param1") String name,@RequestParam(value = "param2") int number){
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
