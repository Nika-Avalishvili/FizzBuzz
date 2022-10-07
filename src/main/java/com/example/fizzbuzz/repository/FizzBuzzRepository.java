package com.example.fizzbuzz.repository;

import com.example.fizzbuzz.model.FizzBuzz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FizzBuzzRepository extends JpaRepository<FizzBuzz, Long> {
}