package com.example.fizzbuzz.repository;

import com.example.fizzbuzz.model.FizzBuzzDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FizzBuzzRepository extends JpaRepository<FizzBuzzDB, Long> {
}
