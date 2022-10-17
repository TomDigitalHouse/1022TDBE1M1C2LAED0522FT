package com.digitalhouse.ej1Alumno;

public class Cuadrado extends Figura{
    public Cuadrado(Double numero) {
        super(numero);
    }

    @Override
    public void calcularArea() {
        if(this.getNumero() < 0){
            System.out.println("El lado del cuadrado debe ser mayor a 0");
            throw new ArithmeticException();
        }
        this.setArea(this.getNumero() * this.getNumero());
    }
}
