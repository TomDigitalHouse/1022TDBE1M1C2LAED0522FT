package com.example.demo.services;

import com.example.demo.model.Profesor;
import com.example.demo.repository.ProfesorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfesorService{

    private final ProfesorRepository repository;


    public Profesor save(Profesor profesor){
        return repository.save(profesor);
    }

    public void deleteById(long id){
        repository.deleteById(id);
    }

    public List<Profesor> getAll(){
        return repository.findAll();
    }

}
