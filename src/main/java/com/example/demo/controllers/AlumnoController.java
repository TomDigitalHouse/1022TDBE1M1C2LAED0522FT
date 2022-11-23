package com.example.demo.controllers;


import com.example.demo.model.Alumno;
import com.example.demo.services.AlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    private final AlumnoService service;

    @GetMapping("/all")
    public ResponseEntity<List<Alumno>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/all/{profesorId}")
    public ResponseEntity<List<Alumno>> addAlumnos(@RequestBody Set<Alumno> alumnos, @PathVariable long profesorId) {
        return ResponseEntity.ok(service.addAlumnos(alumnos, profesorId));
    }
}
