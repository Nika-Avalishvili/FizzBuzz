package com.example.fizzbuzz.repository;

import com.example.fizzbuzz.model.FizzBuzzDB;
import org.springframework.data.repository.CrudRepository;

public interface FizzBuzzRepository extends CrudRepository<FizzBuzzDB, Long> {

}