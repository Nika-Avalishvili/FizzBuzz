package com.example.fizzbuzz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor  //Lombok for all field constructor
@NoArgsConstructor   //Lombok for no field constructor
@Data  //Lombok for getters and setters
public class FizzBuzzDTO {
    private long id;
    private String name;
    private Integer myNumber;
    private String result;

}
