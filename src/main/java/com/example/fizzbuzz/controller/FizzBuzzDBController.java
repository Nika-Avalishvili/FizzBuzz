package com.example.fizzbuzz.controller;

import com.example.fizzbuzz.fizzbuzzServices.FizzBuzzConverter;
import com.example.fizzbuzz.fizzbuzzServices.FizzBuzzResultService;
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
    private FizzBuzzConverter fizzBuzzConverter;

    @PostMapping("/insertValue")
    public @ResponseBody FizzBuzz addNewFizzBuzz (@RequestBody FizzBuzzDTO fizzBuzzDTO) {
        FizzBuzz entry = fizzBuzzConverter.dtoToEntity(fizzBuzzDTO);
        entry.setResult(FizzBuzzResultService.setResult(entry.getMyNumber()));
        FizzBuzz savedEntry = fizzBuzzRepository.save(entry);
        return savedEntry;
    }

    @PutMapping("/updateValue")
    public FizzBuzz updateValues(@RequestBody FizzBuzzDTO fizzBuzzDTO) {
        FizzBuzz entry = fizzBuzzConverter.dtoToEntity(fizzBuzzDTO);
        entry.setResult(FizzBuzzResultService.setResult(entry.getMyNumber()));
        FizzBuzz savedEntry = fizzBuzzRepository.save(entry);
        return savedEntry;
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
