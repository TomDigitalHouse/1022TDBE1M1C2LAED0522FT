package com.example.demo.controller;

import com.example.demo.exceptions.PacienteNotFoundException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Turno;
import com.example.demo.services.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class TurnoController {
    private final TurnoService service;

    @GetMapping("/turnos")
    public List<Turno> listar() {
        return service.listar();
    }

    @PostMapping("/turnos")
    public ResponseEntity<?> listar(@RequestBody Turno turno) throws ResourceNotFoundException, PacienteNotFoundException {
        return ResponseEntity.ok(service.agregar(turno));
    }
}
