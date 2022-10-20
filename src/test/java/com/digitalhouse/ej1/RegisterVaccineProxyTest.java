package com.digitalhouse.ej1;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegisterVaccineProxyTest {

    @Test
    public void test1() {
        //GIVEN
        var vac = new RegisterVaccineProxy();
        var dni = "1234";
        var date = new Date();
        var persona = new Person("Thomas", "Desch", dni, "asd", date);

        //THEN
        //  var ex =
        assertThrows(Exception.class, () -> vac.registrar(persona));
        //assertEquals(actual, expected);
    }

}