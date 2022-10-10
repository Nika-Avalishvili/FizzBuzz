package com.example.fizzbuzz.fizzbuzzServices;

import com.example.fizzbuzz.model.FizzBuzz;
import com.example.fizzbuzz.model.FizzBuzzDTO;
import com.example.fizzbuzz.model.FizzBuzzMapper;
import com.example.fizzbuzz.repository.FizzBuzzRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FizzBuzzService {

    private final FizzBuzzRepository fizzBuzzRepository;
    private final FizzBuzzMapper fizzBuzzMapper;

    public FizzBuzz createEntry(FizzBuzzDTO fizzBuzzDTO){
        FizzBuzz entry = fizzBuzzMapper.dtoToEntity(fizzBuzzDTO);
        entry.setResult(FizzBuzzResultService.setResult(entry.getMyNumber()));
        return fizzBuzzRepository.save(entry);
    }

    public FizzBuzz updateEntry(FizzBuzzDTO fizzBuzzDTO){
        FizzBuzz entry = fizzBuzzMapper.dtoToEntity(fizzBuzzDTO);
        entry.setResult(FizzBuzzResultService.setResult(entry.getMyNumber()));
        return fizzBuzzRepository.save(entry);
    }

    public List<FizzBuzzDTO> findAllEntries(){
        List<FizzBuzz> findAll = fizzBuzzRepository.findAll();
        return fizzBuzzMapper.entityToDto(findAll);
    }

    public FizzBuzzDTO findEntriesById(long id){
        FizzBuzz fbz = fizzBuzzRepository.findById(id).orElse(null);
        return fizzBuzzMapper.entityToDto(fbz);
    }


}
