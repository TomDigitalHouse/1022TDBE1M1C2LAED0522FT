package com.digitalhouse.ej2Alumno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmadoInfantilTest {

    @Test
    @DisplayName("WHEN an employee wants an infantil menu THEN it returns a string")
    void armadoMenuTest() {
        //GIVEN
        var armadoMenu = new ArmadoInfantil();
        //WHEN
        var aux = armadoMenu.armadoMenu();
        //THEN
        assertEquals("El armado del menu infantil debe llevar juguetes",aux);
    }

    @Test
    @DisplayName("WHEN a client wants an infantil menu THEN it returns a price")
    void calcularPrecioVentaTest() {
        //GIVEN
        var cliente = new MenuInfantil(10.0,2);
        var armadoMenu = new ArmadoInfantil();
        //WHEN
        var aux = armadoMenu.calcularPrecioVenta(cliente.getBase(), cliente.calcularRecargo());
        //THEN
        assertEquals(aux,16.0);
    }
}