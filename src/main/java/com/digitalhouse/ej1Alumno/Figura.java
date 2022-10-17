package com.digitalhouse.ej1Alumno;

import lombok.Getter;
import lombok.Setter;

public abstract class Figura {
    private @Getter @Setter Double area;
    private @Getter @Setter Double numero; //Radio o Lado;

    public Figura(Double numero) {
        this.numero = numero;
    }

    public abstract void calcularArea() throws ArithmeticException;
}
