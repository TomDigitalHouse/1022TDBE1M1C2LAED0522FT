package com.example.demo.controller;

import com.example.demo.exceptions.OdontologoNotFound;
import com.example.demo.exceptions.PacienteNotFound;
import com.example.demo.model.Turno;
import com.example.demo.model.TurnoRequest;
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
    public ResponseEntity<?> listar(@RequestBody TurnoRequest turnoRequest) {
        try {
            return ResponseEntity.of(Optional.of(service.agregar(turnoRequest.id(),
                    turnoRequest.pacienteId(),
                    turnoRequest.odontologoId(),
                    turnoRequest.date())));
        } catch (OdontologoNotFound | PacienteNotFound e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
