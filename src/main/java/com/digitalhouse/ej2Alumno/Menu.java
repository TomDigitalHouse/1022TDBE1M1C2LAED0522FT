package com.digitalhouse.ej2Alumno;

import lombok.Getter;

@Getter
public abstract class Menu {
    private double base;

    public Menu(double base) {
        this.base = base;
    }

    public abstract double calcularRecargo();
}
