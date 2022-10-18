package com.digitalhouse.ej2Alumno;

public class MenuClasico extends Menu{
    public MenuClasico(double base) {
        super(base);
    }

    @Override
    public double calcularRecargo() {
        return 0.0;
    }
}
