package com.example.fizzbuzz.controller;

import com.example.fizzbuzz.fizzbuzzServices.FizzBuzzService;
import com.example.fizzbuzz.model.FizzBuzzMapper;
import com.example.fizzbuzz.model.FizzBuzz;
import com.example.fizzbuzz.model.FizzBuzzDTO;
import com.example.fizzbuzz.repository.FizzBuzzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class FizzBuzzDBController {

    @Autowired
    private FizzBuzzRepository fizzBuzzRepository;

    @Autowired
    private FizzBuzzMapper fizzBuzzMapper;

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @PostMapping("/insertValue")
    public @ResponseBody FizzBuzzDTO addNewFizzBuzz (@RequestBody FizzBuzzDTO fizzBuzzDTO) {
        return fizzBuzzService.createEntry(fizzBuzzDTO);
    }

    @PutMapping("/updateValue")
    public FizzBuzzDTO updateValues(@RequestBody FizzBuzzDTO fizzBuzzDTO) {
        return fizzBuzzService.updateEntry(fizzBuzzDTO);
    }

    @DeleteMapping("/deleteValue")
    public void deleteValues(@RequestParam (value = "id") Long id) {
        fizzBuzzRepository.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<FizzBuzzDTO> getAllFizzBuzz() {
        return fizzBuzzService.findAllEntries();
    }

    @GetMapping("/find/{Id}")
    public FizzBuzzDTO findById(@PathVariable (value="Id") Long id) {
        return fizzBuzzService.findEntriesById(id);
    }
}
