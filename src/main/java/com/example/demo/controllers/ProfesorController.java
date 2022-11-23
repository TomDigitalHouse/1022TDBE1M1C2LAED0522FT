package com.example.demo.controllers;


import com.example.demo.model.Profesor;
import com.example.demo.services.ProfesorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
@AllArgsConstructor
public class ProfesorController {
    private final ProfesorService service;

    @PostMapping("/add")
    public ResponseEntity<Profesor> add(@RequestBody Profesor profesor) {
        return ResponseEntity.ok(service.save(profesor));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/all")
    public ResponseEntity<List<Profesor>> all() {
        return ResponseEntity.ok(service.getAll());
    }
}
