package com.digitalhouse.ej2Alumno;

public abstract class Armado {
    public abstract String armadoMenu();
    public double calcularPrecioVenta(double base, double recargo){
        return base+recargo;
    };
}
