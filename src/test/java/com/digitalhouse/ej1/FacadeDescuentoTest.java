package com.digitalhouse.ej1;

import com.digitalhouse.ej1.apis.ApiCantidad;
import com.digitalhouse.ej1.apis.ApiProducto;
import com.digitalhouse.ej1.apis.ApiTarjeta;
import com.digitalhouse.ej1.model.Producto;
import com.digitalhouse.ej1.model.Tarjeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class FacadeDescuentoTest {

    @Test
    @DisplayName("WHEN the facade.descuento is called with 3 apis THEN 3 apis are used")
    public void test1() {
        //GIVEN
        var cantidad = mock(ApiCantidad.class);
        var tarjeta = mock(ApiTarjeta.class);
        var producto = mock(ApiProducto.class);
        var facade = new FacadeDescuento(tarjeta, producto, cantidad);
        var tareta = new Tarjeta("22", "bank");
        var prod = new Producto("", "");
        var catnidad = 5;
        //WHEN
        facade.descuento(tareta, prod, catnidad);
        //THEN
        verify(cantidad).descuento(catnidad);
        verify(tarjeta).descuento(tareta);
        verify(producto).descuento(prod);
    }

}