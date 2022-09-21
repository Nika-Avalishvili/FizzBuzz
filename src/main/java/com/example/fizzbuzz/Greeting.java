package com.example.fizzbuzz;

public class Greeting {
    private String name;
    private int number;
    private String result;

    public Greeting(String name, int number) {
        this.name = name;
        this.number = number;
        this.result = "";
    }

    public String getName(){
        return this.name;
    }

    public int getNumber(){
        return this.number;
    }


    public String getResult(){
        if (number % 3 == 0 ){
            result += "Fizz";
        }
        if (number % 5 == 0 ){
            result += "Buzz";
        }
        return this.result;
    }
}
