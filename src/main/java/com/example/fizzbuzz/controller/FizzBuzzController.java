package com.example.fizzbuzz.controller;

import com.example.fizzbuzz.repository.FizzBuzzRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzzController {

    private final FizzBuzzRepository fizzBuzzRepository;

    public FizzBuzzController(FizzBuzzRepository fizzBuzzRepository) {
        this.fizzBuzzRepository = fizzBuzzRepository;
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(this.fizzBuzzRepository.findAll());
    }
}
