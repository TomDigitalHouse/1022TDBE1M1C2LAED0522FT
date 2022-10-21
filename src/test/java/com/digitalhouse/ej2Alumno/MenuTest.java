package com.digitalhouse.ej2Alumno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    @DisplayName("WHEN a children tries to GET base THEN it returns base")
    void getBase() {
        //GIVEN
        var children = new MenuClasico(10.0);
        //WHEN
        var aux = children.getBase();
        //THEN
        assertEquals(aux,10.0);
    }
}