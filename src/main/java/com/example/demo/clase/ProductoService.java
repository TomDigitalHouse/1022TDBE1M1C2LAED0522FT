package com.example.demo.clase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {
    private final ProductoRepository repository;

    public Producto add(Producto p) {
        return repository.save(p);
    }
    public List<Producto> getAll() {
        return repository.findAll();
    }
    public Producto update(Producto p) {
      return repository.save(p);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
