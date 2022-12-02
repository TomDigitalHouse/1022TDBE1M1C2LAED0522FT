package com.example.demo.services;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Odontologo;
import com.example.demo.repository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OdontologoService {
    private final OdontologoRepository repository;

    public void agregar(Odontologo odontologo) {
        repository.save(odontologo);
    }

    public List<Odontologo> listar() {
        return repository.findAll();
    }

    public void modificar(Odontologo odontologo) {
        repository.save(odontologo);
    }

    public void eliminar(int matricula) {
        repository.deleteByMatricula(matricula);
    }

    public Odontologo getByMatricula(int matricula) throws ResourceNotFoundException {
        return repository.findByMatricula(matricula).orElseThrow(() -> new ResourceNotFoundException());
    }

}