package com.digitalhouse.ej1.liquidadores;

import com.digitalhouse.ej1.empleados.Empleado;
import com.digitalhouse.ej1.empleados.EmpleadoIncorrectoException;
import lombok.Getter;

@Getter
public abstract class Liquidador {
    public abstract int calular(Empleado empleado) throws EmpleadoIncorrectoException;

    public abstract String imprimir(final int saldo);

    public void depositar() {
        System.out.println("Sueldo depositado");
    }

    public final String liquidarSueldo(Empleado empleado) throws EmpleadoIncorrectoException {
        var saldo = calular(empleado);
        depositar();

        return imprimir(saldo);
    }
}
