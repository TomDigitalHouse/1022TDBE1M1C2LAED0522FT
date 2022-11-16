package com.example.demo.model;

import java.time.LocalDate;

public record TurnoRequest(int id, int pacienteId, int odontologoId, LocalDate date) {
}
