package com.example.fizzbuzz.DTO;

import com.example.fizzbuzz.model.FizzBuzz;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FizzBuzzConverter {

    public FizzBuzzDTO entityToDto(FizzBuzz fizzBuzz){
        FizzBuzzDTO dto = new FizzBuzzDTO();
        dto.setId(fizzBuzz.getId());
        dto.setName(fizzBuzz.getName());
        dto.setMyNumber(fizzBuzz.getMyNumber());
        dto.setResult(fizzBuzz.getResult());
        return dto;
    }

    public List<FizzBuzzDTO> entityToDto(List<FizzBuzz> fizzBuzz){
        return fizzBuzz.stream().map( x -> entityToDto(x)).collect(Collectors.toList());
    }

    public FizzBuzz dtoToEntity(FizzBuzzDTO dto){
        FizzBuzz fb = new FizzBuzz();
        fb.setId(dto.getId());
        fb.setName(dto.getName());
        fb.setMyNumber(dto.getMyNumber());
        fb.setResult(dto.getResult());
        return fb;
    }

    public List<FizzBuzz> dtoToEntity(List<FizzBuzzDTO> dto){
        return dto.stream().map( x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
