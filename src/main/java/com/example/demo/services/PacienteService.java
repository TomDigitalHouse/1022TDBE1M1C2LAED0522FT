package com.example.demo.services;


import com.example.demo.exceptions.PacienteNotFoundException;
import com.example.demo.model.Paciente;
import com.example.demo.repository.Dao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PacienteService {
    private final Dao<Paciente> pacienteDaoH2;

    public void agregar(Paciente paciente) {
        pacienteDaoH2.add(paciente);
    }

    public List<Paciente> listar() {
        return pacienteDaoH2.getAll();
    }

    public void modificar(Paciente paciente) {
        pacienteDaoH2.update(paciente);
    }

    public void eliminar(int id) {
        pacienteDaoH2.delete(id);
    }

    public Paciente getById(int id) throws PacienteNotFoundException {
        return pacienteDaoH2.getBy(id).orElseThrow(PacienteNotFoundException::new);
    }

}
