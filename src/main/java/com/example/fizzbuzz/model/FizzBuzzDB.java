package com.example.fizzbuzz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FizzBuzzDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Integer myNumber;
    private String result;

    public FizzBuzzDB() {
    }

    public FizzBuzzDB(long id, String name, Integer myNumber, String result) {
        this.id = id;
        this.name = name;
        this.myNumber = myNumber;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(Integer myNumber) {
        this.myNumber = myNumber;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
