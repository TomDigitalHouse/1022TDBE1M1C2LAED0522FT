package com.digitalhouse.ej1;

import com.digitalhouse.ej1.empleados.EmpleadoContratado;
import com.digitalhouse.ej1.empleados.EmpleadoEfectivo;
import com.digitalhouse.ej1.empleados.EmpleadoIncorrectoException;
import com.digitalhouse.ej1.liquidadores.LiquidadorEfectivo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LiquidadorEfectivoTest {
    @Test
    public void test1() throws EmpleadoIncorrectoException {
        //GIVEN
        var empleado = new EmpleadoEfectivo("Thomas", 400, 40, 60);
        var liquidador = new LiquidadorEfectivo();
        //WHEN
        var actual = liquidador.liquidarSueldo(empleado);
        //THEN
        assertEquals(actual, "La liquidación generada es un documento digital." +
                " Saldo a liquidar: 420");
    }

    @Test
    @DisplayName("WHEN we call liquidarSueldo with a wrong empleado THEN it should throw an Excepction")
    public void test2() {
        //GIVEN
        var empleado = new EmpleadoContratado("Thomas", 400, 40);
        var liquidador = new LiquidadorEfectivo();
        //THEN
        var ex =
                assertThrows(EmpleadoIncorrectoException.class, () -> liquidador.liquidarSueldo(empleado));
        assertEquals(ex.getMessage(), "La liquidación no pudo ser calculada.");
    }

}
