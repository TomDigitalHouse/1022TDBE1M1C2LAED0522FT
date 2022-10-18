package com.digitalhouse.ej1;

import com.digitalhouse.ej1.empleados.Empleado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmpleadoTest {
    @Test
    @DisplayName("WHEN a empleado is created THEN it should have the right name")
    public void test1() {
        //GIVEN
        var nombre = "Thomas";
        var empleado = new EmpleadoStub("Thomas");
        //WHEN
        var actual = empleado.nombre;
        //THEN
        assertEquals(nombre, actual);
    }

    private static class EmpleadoStub extends Empleado {
        public EmpleadoStub(String nombre) {
            super(nombre);
        }
    }
}