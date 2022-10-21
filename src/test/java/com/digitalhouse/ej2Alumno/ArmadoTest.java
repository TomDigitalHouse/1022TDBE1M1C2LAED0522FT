package com.digitalhouse.ej2Alumno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmadoTest {

    @Test
    @DisplayName("WHEN a children of Armado uses calcularPrecioVenta method THEN it returns a double")
    void calcularPrecioVenta() {
        //GIVEN
        var children = new ArmadoClasico();
        //WHEN
        var aux = children.calcularPrecioVenta(1.0,2.0);
        //THEN
        assertEquals(aux,3.0);
    }
}