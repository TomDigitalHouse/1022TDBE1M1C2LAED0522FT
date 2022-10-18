package com.digitalhouse.ej1;

import com.digitalhouse.ej1.empleados.Empleado;
import com.digitalhouse.ej1.empleados.EmpleadoIncorrectoException;
import com.digitalhouse.ej1.liquidadores.Liquidador;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class LiquidadorTest {
    @Test
    @DisplayName("WHEN liquidar sueldo is called THEN it should call its methods")
    public void test1() throws EmpleadoIncorrectoException {
        //GIVEN
        var liquidador = mock(Liquidador.class);
        var empleado = mock(Empleado.class);
        //WHEN
        liquidador.liquidarSueldo(empleado);
        //THEN
        verify(liquidador).calcular(empleado);
        verify(liquidador).imprimir(anyInt());
        verify(liquidador).depositar();
    }
}