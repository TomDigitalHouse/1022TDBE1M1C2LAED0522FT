package com.example.demo.clase;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MovimientoService {
    private final MovimientoRepository repository;

    public Movimiento add(Movimiento movimiento){
        return repository.save(movimiento);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public List<Movimiento> getAll(){
        return repository.findAll();
    }

    public Movimiento update(Movimiento m){
        return repository.save(m);
    }
}
