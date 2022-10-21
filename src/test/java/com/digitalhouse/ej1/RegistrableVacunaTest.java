package com.digitalhouse.ej1;

import model.Persona;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrableVacunaTest {

    @Test
    @DisplayName("WHEN el metodo vacunar es llamado THEN deberia devolver el mensaje correcto")
    public void test1(){
        //GIVEN
        var nombre = "Joaquin";
        var apellido = "Stechina";
        var fecha = LocalDate.now();
        var vacuna = "Pfizer";
        var persona = new Persona(nombre, apellido, "1234", vacuna, fecha);
        var registrableVacuna = new RegistrableVacuna();
        //WHEN
        var mensaje = registrableVacuna.vacunar(persona);
        //THEN
        var mensajeEsperado = "La persona "+nombre+" "+apellido+ "fue vacunada el dia "+fecha+ "con la vacuna "+vacuna;
        assertEquals(mensaje, mensajeEsperado);
    }

}
