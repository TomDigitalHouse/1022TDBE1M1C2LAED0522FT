package com.example.demo.controller;


import com.example.demo.model.Entrenador;
import com.example.demo.service.EntrenadorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrenadorController {
    private final EntrenadorService entrenadorService;

    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping("/entrenadores")
    public List<Entrenador> getEntrenadores() {
        return entrenadorService.getEntrenadores();
    }
}
