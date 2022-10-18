package com.digitalhouse.ej1.empleados;

public class EmpleadoIncorrectoException extends Exception{
    public EmpleadoIncorrectoException() {
        super("La liquidación no pudo ser calculada.");
    }
}
