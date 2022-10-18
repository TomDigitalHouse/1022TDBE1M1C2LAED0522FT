package com.digitalhouse.ej2Alumno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmadoClasicoTest {

    @Test
    @DisplayName("WHEN an employee wants a clasico menu THEN it returns a string")
    void armadoMenuTest() {
        //GIVEN
        var armadoMenu = new ArmadoClasico();
        //WHEN
        var aux = armadoMenu.armadoMenu();
        //THEN
        assertEquals("El armado del menu clasico no lleva adicionales",aux);
    }

    @Test
    @DisplayName("WHEN a client wants a clasico menu THEN it returns a price")
    void calcularPrecioVentaTest() {
        //GIVEN
        var cliente = new MenuClasico(10.0);
        var armadoMenu = new ArmadoClasico();
        //WHEN
        var aux = armadoMenu.calcularPrecioVenta(cliente.getBase(), cliente.calcularRecargo());
        //THEN
        assertEquals(aux,10.0);
    }
}