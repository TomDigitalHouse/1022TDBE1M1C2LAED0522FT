package com.digitalhouse.ej2Alumno;

public class MenuInfantil extends Menu{
    private int juguetes;

    public MenuInfantil(double base,int juguetes) {
        super(base);
        this.juguetes = juguetes;
    }

    @Override
    public double calcularRecargo() {
        return (this.juguetes*3);
    }
}
