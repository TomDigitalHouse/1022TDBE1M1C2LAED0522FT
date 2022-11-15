package com.example.demo.model;

import java.sql.Date;

public record Paciente(int id, String nombre, String apellido, String domicilio, String dni, Date fechaAlta) {
}
