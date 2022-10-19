package com.digitalhouse.ej1;

import com.digitalhouse.ej1.empleados.Empleado;
import com.digitalhouse.ej1.empleados.EmpleadoContratado;
import com.digitalhouse.ej1.empleados.EmpleadoIncorrectoException;
import com.digitalhouse.ej1.liquidadores.Liquidador;

public class LiquidadorContratado extends Liquidador {
    @Override
    public int calcular(Empleado empleado) throws EmpleadoIncorrectoException {
       if (empleado instanceof EmpleadoContratado e){
           return e.getRate()*e.getHoras();
       }
       throw new EmpleadoIncorrectoException();
    }

    @Override
    public String imprimir(int saldo) {
        return "La liquidación generada es un documento impreso." +
        " Saldo a liquidar: " +saldo;
    }
}
