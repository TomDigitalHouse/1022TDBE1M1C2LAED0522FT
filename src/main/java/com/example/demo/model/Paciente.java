package com.example.demo.model;

import java.time.LocalDate;

public record Paciente(int id, String nombre, String apellido, String domicilio, String dni, LocalDate fechaAlta) {
}
