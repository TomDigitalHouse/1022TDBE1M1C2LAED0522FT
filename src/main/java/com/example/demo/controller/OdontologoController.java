package com.example.demo.controller;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Odontologo;
import com.example.demo.services.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class OdontologoController {
    private final OdontologoService service;

    @GetMapping("/odontologos")
    public List<Odontologo> listar() {
        return service.listar();
    }

    @PostMapping("/nuevosOdontologos")
    public void agregar(@RequestBody Odontologo paciente) {
         service.agregar(paciente);
    }

    @PutMapping("/modificarOdontologos")
    public void modificar(@RequestBody Odontologo paciente) {
        service.modificar(paciente);
    }

    @DeleteMapping("/eliminarOdontologo")
    public void eliminar(@RequestBody int id) {
        service.eliminar(id);
    }
    @GetMapping("/odontologos/{id}")
    public ResponseEntity<Odontologo> getByMatricula(@PathVariable int id) throws ResourceNotFoundException {
        var odontologo = service.getByMatricula(id);
        return ResponseEntity.ok(odontologo);
    }
}
