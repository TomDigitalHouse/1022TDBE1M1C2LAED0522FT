package com.digitalhouse.ej1.empleados;

import lombok.Getter;

@Getter
public class EmpleadoContratado extends Empleado{
    private final int horas;
    private final int rate;

    public EmpleadoContratado(String nombre, int horas, int rate) {
        super(nombre);
        this.horas = horas;
        this.rate = rate;
    }
}
