package com.example.demo.repository.service;

import com.example.demo.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    Optional<Paciente> getPaciente(String email);
    List<Paciente> getAll();

    void add(Paciente p);
}
