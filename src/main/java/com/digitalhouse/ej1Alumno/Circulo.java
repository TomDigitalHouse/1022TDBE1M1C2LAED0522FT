package com.digitalhouse.ej1Alumno;

public class Circulo extends Figura{
    public Circulo(Double numero) {
        super(numero);
    }

    @Override
    public void calcularArea() {
        if(this.getNumero() < 0) {
            System.out.println("El radio del circulo debe ser mayor a 0");
            throw new ArithmeticException();
        }
        this.setArea(Math.PI* ( this.getNumero() * this.getNumero() ) );
    }
}