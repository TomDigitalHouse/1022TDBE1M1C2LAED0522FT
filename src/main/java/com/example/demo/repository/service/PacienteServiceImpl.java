package com.example.demo.repository.service;

import com.example.demo.model.Paciente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {


    private static final List<Paciente> pacientes = new ArrayList<>();

    @Override
    public Optional<Paciente> getPaciente(String email) {
       return pacientes.stream().filter(paciente -> paciente.email().equalsIgnoreCase(email)).findFirst();
    }

    @Override
    public List<Paciente> getAll() {
        return pacientes;
    }

    @Override
    public void add(Paciente p) {
        pacientes.add(p);
    }
}
