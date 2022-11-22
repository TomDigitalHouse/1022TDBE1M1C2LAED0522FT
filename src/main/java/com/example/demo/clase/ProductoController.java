package com.example.demo.clase;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductoController {
    private final ProductoService service;

    @PostMapping("/create")
    public ResponseEntity<Producto> create(@RequestBody Producto p){
        return ResponseEntity.ok(service.add(p));
    }
    @GetMapping("/read")
    public ResponseEntity<List<Producto>> read(){
        return ResponseEntity.ok(service.getAll());
    }
    @PutMapping("/update")
    public ResponseEntity<Producto> update(@RequestBody Producto p){
        return ResponseEntity.ok(service.update(p));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.ok(id+ "eliminado");
    }
}
