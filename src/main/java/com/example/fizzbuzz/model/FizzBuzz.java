package com.example.fizzbuzz.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor  //Lombok for all field constructor
@NoArgsConstructor   //Lombok for no field constructor
@Data  //Lombok for getters and setters
public class FizzBuzz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Integer myNumber;
    private String result;

}
