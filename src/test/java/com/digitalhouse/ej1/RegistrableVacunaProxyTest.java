package com.digitalhouse.ej1;

import model.Persona;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegistrableVacunaProxyTest {

    @Test
    public void test1() {
        //GIVEN
        var vac = new RegistrableVacunaProxy();
        var dni = "1234";
        var date = LocalDate.now();
        var persona = new Persona("Thomas", "Desch", dni, "asd", date);

        //THEN
        assertThrows(OldDateException.class, () -> vac.registrar(persona));
    }

    @Test
    public void test2() throws OldDateException {
        //GIVEN
        var vac = new RegistrableVacunaProxy();
        var dni = "1234";
        var date = LocalDate.of(2022, 11, 4);
        var persona = new Persona("Thomas", "Desch", dni, "asd", date);
        //WHEN
        var actual = vac.registrar(persona);
        //THEN
        assertEquals(actual, "Se ha registrado el " + dni + " en la fecha " + date + " como vacunado ");
    }
}