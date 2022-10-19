package com.digitalhouse.ej1.liquidadores;

import com.digitalhouse.ej1.empleados.Empleado;
import com.digitalhouse.ej1.empleados.EmpleadoEfectivo;
import com.digitalhouse.ej1.empleados.EmpleadoIncorrectoException;
import com.digitalhouse.ej1.liquidadores.Liquidador;

public class LiquidadorEfectivo extends Liquidador {
    @Override
    public int calcular(Empleado empleado) throws EmpleadoIncorrectoException {
        if (empleado instanceof EmpleadoEfectivo e){
            return e.getPremios()+e.getSueldoBasico()-e.getDescuentos();
        }
        throw new EmpleadoIncorrectoException();
    }

    @Override
    public String imprimir(int saldo) {
       return "La liquidación generada es un documento digital." +
        " Saldo a liquidar: "+saldo;
    }
}
