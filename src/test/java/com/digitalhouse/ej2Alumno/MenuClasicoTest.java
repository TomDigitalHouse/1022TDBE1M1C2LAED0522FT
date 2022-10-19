package com.digitalhouse.ej2Alumno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuClasicoTest {

    @Test
    @DisplayName("WHEN the method calcularRecargo THEN it returns a double")
    void calcularRecargo() {
        //GIVEN
        var cliente = new MenuClasico(10.0);
        //WHEN
        var aux = cliente.calcularRecargo();
        //THEN
        assertEquals(aux,0.0);
    }
}