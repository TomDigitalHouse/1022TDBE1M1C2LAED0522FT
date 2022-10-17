package com.digitalhouse.ej1Alumno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiguraTest {

    @Test
    @DisplayName("WHEN a Cuadrado object calls its calcularArea method THEN it should set the correct area")
    void testeandoAreaCuadrado(){
        //GIVEN
        var cuadradin = new Cuadrado(4.0);
        //WHEN
        cuadradin.calcularArea();
        //THEN
        assertEquals(cuadradin.getArea(),16.0);
    }

    @Test
    @DisplayName("WHEN a Circulo object calls its calcularArea method THEN it should set the correct area")
    void testeandoAreaCirculo(){
        //GIVEN
        var circulin = new Circulo(4.0);
        //WHEN
        circulin.calcularArea();
        //THEN
        assertEquals(circulin.getArea(),(Math.PI*16.0));
    }

    @Test
    @DisplayName("GIVEN a Cuadrado object with -1.0 as numero THEN it should throw an ArithmeticException")
    void testeandoFalloAritmeticoCuadrado(){
        //GIVEN
        var cuadradin = new Cuadrado(-1.0);
        //THEN
        assertThrows(ArithmeticException.class, ()-> cuadradin.calcularArea());
    }

    @Test
    @DisplayName("GIVEN a Circulo object with -1.0 as numero THEN it should throw an ArithmeticException")
    void testeandoFalloAritmeticoCirculo(){
        //GIVEN
        var circulin = new Circulo(-1.0);
        //THEN
        assertThrows(ArithmeticException.class, ()-> circulin.calcularArea());
    }
}
