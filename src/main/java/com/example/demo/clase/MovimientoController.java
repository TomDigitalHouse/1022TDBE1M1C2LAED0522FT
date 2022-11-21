package com.example.demo.clase;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MovimientoController {
    private final MovimientoService service;

    @GetMapping("/movimientos")
    public ResponseEntity<List<Movimiento>> listar() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping("/addMovimiento")
    public ResponseEntity<Movimiento> agregar(@RequestBody Movimiento movimiento) {
      return ResponseEntity.ok().body(service.add(movimiento));
    }

}
