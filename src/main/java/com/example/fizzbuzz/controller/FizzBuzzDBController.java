package com.example.fizzbuzz.controller;

import com.example.fizzbuzz.fizzbuzzServices.FizzBuzzResultService;
import com.example.fizzbuzz.model.FizzBuzzDB;
import com.example.fizzbuzz.repository.FizzBuzzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FizzBuzzDBController {

    @Autowired
    private FizzBuzzRepository fizzBuzzRepository;

    @PostMapping("/insertValue")
    public @ResponseBody FizzBuzzDB addNewFizzBuzz (@RequestParam (value = "myNumber") Integer myNumber, @RequestParam (value = "name") String name) {
        FizzBuzzDB entry = new FizzBuzzDB();
        entry.setName(name);
        entry.setMyNumber(myNumber);
        entry.setResult(FizzBuzzResultService.setResult(myNumber));
        FizzBuzzDB savedEntry = fizzBuzzRepository.save(entry);
        return savedEntry;
    }

    @PutMapping("/updateValue")
    public FizzBuzzDB updateValues(@RequestParam (value = "id") Long id, @RequestParam (value = "myNumber") Integer myNumber, @RequestParam (value = "name") String name) {
        FizzBuzzDB entry = new FizzBuzzDB();
        entry.setId(id);
        entry.setName(name);
        entry.setMyNumber(myNumber);
        entry.setResult(FizzBuzzResultService.setResult(myNumber));
        FizzBuzzDB savedEntry = fizzBuzzRepository.save(entry);
        return savedEntry;
    }

    @DeleteMapping("/deleteValue")
    public void deleteValues(@RequestParam (value = "id") Long id) {
        fizzBuzzRepository.deleteById(id);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<FizzBuzzDB> getAllFizzBuzz() {
        return fizzBuzzRepository.findAll();
    }
}
