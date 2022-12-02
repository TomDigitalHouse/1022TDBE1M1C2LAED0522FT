package com.example.demo.controllers;

import com.example.demo.model.Paquete;
import com.example.demo.services.PaqueteException;
import com.example.demo.services.PaqueteService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/paquetes")
public class PaqueteController {

    private static final Logger logger = LoggerFactory.getLogger(PaqueteController.class);
    private final PaqueteService service;

    @GetMapping
    public ResponseEntity<List<Paquete>> getPaquetes(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Paquete paquete){
        try {
            return ResponseEntity.ok(service.agregar(paquete));
        } catch (PaqueteException e) {
            logger.error(e.getMessage());
           return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/en-camino")
    public ResponseEntity<List<Paquete>> getPaquetesEnCamino(){
        return ResponseEntity.ok(service.listarPaquetesEnCamino());
    }
}
