package com.digitalhouse.ej2Alumno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuInfantilTest {

    @Test
    @DisplayName("WHEN the method calcularRecargo THEN it returns a double")
    void calcularRecargo() {
        //GIVEN
        var aux1 = new MenuInfantil(10.0,2);
        //WHEN
        var aux2 = aux1.calcularRecargo();
        //THEN
        assertEquals(aux2,6.0);
    }
}