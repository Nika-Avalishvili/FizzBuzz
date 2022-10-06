package com.example.fizzbuzz.controller;

import com.example.fizzbuzz.DTO.FizzBuzzConverter;
import com.example.fizzbuzz.fizzbuzzServices.FizzBuzzResultService;
import com.example.fizzbuzz.model.FizzBuzz;
import com.example.fizzbuzz.DTO.FizzBuzzDTO;
import com.example.fizzbuzz.repository.FizzBuzzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FizzBuzzDBController {

    @Autowired
    private FizzBuzzRepository fizzBuzzRepository;

    @Autowired
    private FizzBuzzConverter fizzBuzzConverter;

    @PostMapping("/insertValue")
    public @ResponseBody FizzBuzz addNewFizzBuzz (@RequestParam (value = "myNumber") Integer myNumber, @RequestParam (value = "name") String name) {
        FizzBuzz entry = new FizzBuzz();
        entry.setName(name);
        entry.setMyNumber(myNumber);
        entry.setResult(FizzBuzzResultService.setResult(myNumber));
        fizzBuzzRepository.save(entry);
        return entry;
    }

    @PutMapping("/updateValue")
    public FizzBuzz updateValues(@RequestParam (value = "id") Long id, @RequestParam (value = "myNumber") Integer myNumber, @RequestParam (value = "name") String name) {
        FizzBuzz entry = new FizzBuzz();
        entry.setId(id);
        entry.setName(name);
        entry.setMyNumber(myNumber);
        entry.setResult(FizzBuzzResultService.setResult(myNumber));
        fizzBuzzRepository.save(entry);
        return entry;
    }

    @DeleteMapping("/deleteValue")
    public void deleteValues(@RequestParam (value = "id") Long id) {
        fizzBuzzRepository.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<FizzBuzzDTO> getAllFizzBuzz() {
        List<FizzBuzz> findAll = fizzBuzzRepository.findAll();
        return fizzBuzzConverter.entityToDto(findAll);
    }

    @GetMapping("/find/{Id}")
    public FizzBuzzDTO findById(@PathVariable (value="Id") Long id) {
        FizzBuzz fbz = fizzBuzzRepository.findById(id).orElse(null);
        return fizzBuzzConverter.entityToDto(fbz);
    }

}
