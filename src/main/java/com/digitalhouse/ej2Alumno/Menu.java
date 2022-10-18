package com.digitalhouse.ej2Alumno;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Menu {
    private final double base;

    public abstract double calcularRecargo();
}
