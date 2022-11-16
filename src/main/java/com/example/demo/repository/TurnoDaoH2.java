package com.example.demo.repository;

import com.example.demo.model.Odontologo;
import com.example.demo.model.Paciente;
import com.example.demo.model.Turno;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class TurnoDaoH2 implements Dao<Turno> {
    private final List<Turno> turnos = new ArrayList<>();

    @Override
    public List<Turno> getAll() {
        return turnos;
    }

    @Override
    public void add(Turno turno) {
        turnos.add(turno);
    }

    @Override
    public void update(Turno entidad) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Optional<Turno> getBy(int id) {
        return Optional.empty();
    }
}
