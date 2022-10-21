package com.digitalhouse.ej1;

import model.Persona;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrableVacunaTest {

    @Test
    public void test1() {
        //GIVEN
        var vac = new RegistrableVacuna();
        var dni = "1234";
        var date = LocalDate.now();
        var persona = new Persona("Thomas", "Desch", dni, "asd", date);
        //WHEN
        var actual = vac.registrar(persona);
        //THEN
        var expected = "Se ha registrado el " + dni + " en la fecha " + date + " como vacunado ";
        assertEquals(actual, expected);
    }
}