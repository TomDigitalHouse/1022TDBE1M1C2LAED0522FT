package com.digitalhouse.ej2Alumno;

public class MenuVegetariano extends Menu{
    private final boolean especias;
    private final int salsas;

    public MenuVegetariano(double base, boolean especias, int salsas) {
        super(base);
        this.especias = especias;
        this.salsas = salsas;
    }

    @Override
    public double calcularRecargo() {
        if(especias) return this.getBase() * 0.01 +(2 * this.salsas);
        return (2 * this.salsas);
    }
}
