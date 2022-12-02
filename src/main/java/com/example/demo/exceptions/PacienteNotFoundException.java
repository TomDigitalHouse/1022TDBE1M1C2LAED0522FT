package com.example.demo.exceptions;

public class PacienteNotFoundException extends Exception{

    public PacienteNotFoundException() {
        super("Paciente no encontrado");
    }

}
