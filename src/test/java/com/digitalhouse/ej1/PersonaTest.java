package com.digitalhouse.ej1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonaTest {

    @Test
    @DisplayName("WHEN a persona object is created THEN it has the right params")
    public void test1(){
        //GIVEN
        var nombre = "Thomas";
        var edad = 23;
        //WHEN
        var persona = new Persona(nombre,edad);
        //THEN
        assertEquals(persona.nombre(), nombre);
        assertEquals(persona.edad(), edad);
    }

}
