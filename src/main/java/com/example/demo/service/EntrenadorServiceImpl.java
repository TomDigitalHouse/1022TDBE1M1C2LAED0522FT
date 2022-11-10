package com.example.demo.service;

import com.example.demo.model.Entrenador;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EntrenadorServiceImpl implements EntrenadorService{
    private final List<Entrenador> entrenadores = Arrays.asList(new Entrenador("entrenador1"), new Entrenador("entrenador 2"));

    @Override
    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }
}
