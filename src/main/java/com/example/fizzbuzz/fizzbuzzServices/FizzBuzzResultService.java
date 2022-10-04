package com.example.fizzbuzz.fizzbuzzServices;

public class FizzBuzzResultService {
    public static String setResult(Integer myNumber){
        String result = "";
        if (myNumber % 3 == 0){
            result += "Fizz";
        }
        if (myNumber % 5 == 0){
            result += "Buzz";
        }
        return result;
    }
}
