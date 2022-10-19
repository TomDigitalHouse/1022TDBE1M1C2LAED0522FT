package com.digitalhouse.ej1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrupoTest {

    @Test
    @DisplayName("WHEN we try to add a persona with less than 18y THEN it throws an Excepction")
    public void test1(){
        //GIVEN
        var persona = new Persona("Joaquin", 16);
        var grupo = new Grupo();
        //THEN
        assertThrows(UnderAgeException.class, ()-> grupo.addPersona(persona));
    }

    @Test
    @DisplayName("WHEN intentamos añadir una persona con menos de 5 letrs THEN arroja una exepcion")
    public void test2(){
        //GIVEN
        var persona = new Persona("juan", 40);
        var grupo = new Grupo();
        //THEN
        assertThrows(NoTieneSuficentesLetrasExeception.class, ()-> grupo.addPersona(persona));
    }

    @Test
    @DisplayName("WHEN intentamos añadir una persona con mas de 18 y con mas de 5 letras THEN se añade correctamente")
    public void test3() throws UnderAgeException, NoTieneSuficentesLetrasExeception {
        //GIVEN
        var persona = new Persona("thomas", 40);
        var grupo = new Grupo();
        //WHEN
        grupo.addPersona(persona);
        //THEN
        assertTrue(grupo.getPersonas().contains(persona));
    }

}
