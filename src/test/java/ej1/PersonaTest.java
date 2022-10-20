package ej1;

import com.digitalhouse.ej1.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonaTest {
    @Test
    @DisplayName("WHEN a persona object is created THEN it has the right params")
    public void test1(){
        //GIVEN
        var nombre = "Thomas";
        var surname = "Thomas";
        var dni = "123456";
        var vaccine = "moderna";
        var date = new Date();
        //WHEN
        var persona = new Person(nombre, surname, dni, vaccine, date);
        //THEN
        assertEquals(persona.name(), nombre);
        assertEquals(persona.surname(), surname);
        assertEquals(persona.surname(), surname);
        assertEquals(persona.dni(), dni);
        assertEquals(persona.vaccine(), vaccine);
        assertEquals(persona.date(), date);
    }
}