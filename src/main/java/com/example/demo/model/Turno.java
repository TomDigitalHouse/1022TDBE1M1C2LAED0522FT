package com.example.demo.model;

import java.time.LocalDate;

public record Turno(int id, Odontologo odontologo, Paciente paciente, LocalDate fecha) {
}
