package com.digitalhouse.ej1;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterVaccineTest {

    @Test
    public void test1(){
        //GIVEN
        var vac = new RegisterVaccine();
        var dni = "1234";
        var date = new Date();
        var persona = new Person("Thomas", "Desch", dni, "asd", date);
        //WHEN
        var actual = vac.registrar(persona);
        //THEN
        var expected = "Se ha registrado el " + dni + " en la fecha " + date + " como vacunado ";
        assertEquals(actual, expected);
    }
}