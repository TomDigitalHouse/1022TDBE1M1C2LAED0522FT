package com.example.demo.controller;

import com.example.demo.exceptions.PacienteNotFoundException;
import com.example.demo.model.Paciente;
import com.example.demo.services.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PacienteController {
    private final PacienteService pacienteService;

    @GetMapping("/pacientes")
    public List<Paciente> listar() {
        return pacienteService.listar();
    }

    @PostMapping("/nuevosPacientes")
    public void agregar(@RequestBody Paciente paciente) {
        if (paciente != null) pacienteService.agregar(paciente);
    }

    @PutMapping("/modificarPacientes")
    public void modificar(@RequestBody Paciente paciente) {
        pacienteService.modificar(paciente);
    }

    @DeleteMapping("/eliminarPaciente")
    public void eliminar(@RequestBody int id) {
        pacienteService.eliminar(id);
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> getByMatricula(@PathVariable int id) throws PacienteNotFoundException {
        return ResponseEntity.ok(pacienteService.getById(id));
    }
}
