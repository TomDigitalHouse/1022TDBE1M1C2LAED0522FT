package com.digitalhouse.ej2Alumno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmadoVegetarianoTest {

    @Test
    @DisplayName("WHEN an employee wants a vegetariano menu THEN it returns a string")
    void armadoMenuTest() {
        //GIVEN
        var armadoMenu = new ArmadoVegetariano();
        //WHEN
        var aux = armadoMenu.armadoMenu();
        //THEN
        assertEquals("El armado del menu vegetariano lleva especias y salsas",aux);
    }

    @Test
    @DisplayName("WHEN a client wants a vegetariano menu WITH spices THEN it returns a price")
    void calcularPrecioVentaTest() {
        //GIVEN
        var cliente = new MenuVegetariano(10.0,true,4);
        var armadoMenu = new ArmadoVegetariano();
        //WHEN
        var aux = armadoMenu.calcularPrecioVenta(cliente.getBase(), cliente.calcularRecargo());
        //THEN
        assertEquals(aux,18.1);
    }

    @Test
    @DisplayName("WHEN a client wants a vegetariano menu WITHOUT spices THEN it returns a price")
    void calcularPrecioVentaSinEspeciasTest() {
        //GIVEN
        var cliente = new MenuVegetariano(10.0,false,4);
        var armadoMenu = new ArmadoVegetariano();
        //WHEN
        var aux = armadoMenu.calcularPrecioVenta(cliente.getBase(), cliente.calcularRecargo());
        //THEN
        assertEquals(aux,18.0);
    }
}