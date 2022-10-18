package com.digitalhouse.ej2Alumno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuVegetarianoTest {

    @Test
    @DisplayName("GIVEN a menu vegetariano WITHOUT especias WHEN the method calcularRecargo THEN it returns a double")
    void calcularRecargo() {
        //GIVEN
        var cliente = new MenuVegetariano(10.0,false,2);
        //WHEN
        var aux = cliente.calcularRecargo();
        //THEN
        assertEquals(aux,4.0);
    }

    @Test
    @DisplayName("GIVEN a menu vegetariano WITH especias WHEN the method calcularRecargo THEN it returns a double")
    void calcularRecargoSpice() {
        //GIVEN
        var cliente = new MenuVegetariano(10.0,true,2);
        //WHEN
        var aux = cliente.calcularRecargo();
        //THEN
        assertEquals(aux,4.1);
    }
}