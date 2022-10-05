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
    public @ResponseBody String addNewFizzBuzz (@RequestParam(value = "id") Long id, @RequestParam (value = "myNumber") Integer myNumber, @RequestParam (value = "name") String name) {
        FizzBuzzDB entry = new FizzBuzzDB();
        entry.setId(id);
        entry.setName(name);
        entry.setMyNumber(myNumber);
        entry.setResult(FizzBuzzResultService.setResult(myNumber));
        fizzBuzzRepository.save(entry);
        return "Saved";
    }

    @PutMapping("/updateValue")
    public String updateValues(@RequestParam (value = "id") Long id, @RequestParam (value = "myNumber") Integer myNumber, @RequestParam (value = "name") String name) {
        FizzBuzzDB entry = new FizzBuzzDB();
        entry.setId(id);
        entry.setName(name);
        entry.setMyNumber(myNumber);
        entry.setResult(FizzBuzzResultService.setResult(myNumber));
        fizzBuzzRepository.save(entry);
        return "Updated";
    }

    @DeleteMapping("/deleteValue")
    public String deleteValues(@RequestParam (value = "id") Long id) {
        fizzBuzzRepository.deleteById(id);
        return "Deleted";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<FizzBuzzDB> getAllFizzBuzz() {
        return fizzBuzzRepository.findAll();
    }
}
