package com.digitalhouse.ej1.empleados;

import lombok.Getter;

@Getter
public class EmpleadoEfectivo extends Empleado {
    private final int sueldoBasico;
    private final int descuentos;
    private final int premios;

    public EmpleadoEfectivo(String nombre, int sueldoBasico, int descuentos, int premios) {
        super(nombre);
        this.sueldoBasico = sueldoBasico;
        this.descuentos = descuentos;
        this.premios = premios;
    }
}
