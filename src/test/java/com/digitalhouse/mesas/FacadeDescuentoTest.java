package com.digitalhouse.mesas;

import com.digitalhouse.mesas.apis.AvionAPI;
import com.digitalhouse.mesas.apis.HotelAPI;
import com.digitalhouse.mesas.facade.CheckFacade;
import com.digitalhouse.mesas.model.Viaje;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class FacadeDescuentoTest {

    @Test
    @DisplayName("WHEN the facade.descuento is called with 3 apis THEN 3 apis are used")
    public void test1() {
        //GIVEN
        var hotelAPI = mock(HotelAPI.class);
        var avionAPI = mock(AvionAPI.class);
        var facade = new CheckFacade(avionAPI, hotelAPI);
        var fechaIda = "";
        var fechaVuelta = "";
        var origen = "";
        var destino = "";
        //facade.buscar("02/07/2018", "08/07/2018", "Lima", "Cancún");
        //WHEN
        facade.buscar(fechaIda, fechaVuelta, origen, destino);
        //THEN
        verify(hotelAPI).buscarHoteles(fechaIda, fechaVuelta, origen);
        verify(avionAPI).buscarVuelos(fechaIda, fechaVuelta, origen, destino);
    }

    @Test
    @DisplayName("WHEN the facade.descuento is called with 3 apis THEN 3 apis are used")
    public void test2() {
        //GIVEN
        var hotelAPI = mock(HotelAPI.class);
        var avionAPI = mock(AvionAPI.class);
        var facade = new CheckFacade(avionAPI, hotelAPI);
        var viaje = new Viaje(LocalDate.now(), LocalDate.now().plusDays(30), "Lima", "Cancún");
        //WHEN
        facade.buscar(viaje);
        //THEN
        verify(hotelAPI).buscarHoteles(viaje.fechaIda().toString(), viaje.fechaVuelta().toString(), viaje.destino());
        verify(avionAPI).buscarVuelos(viaje.fechaIda().toString(), viaje.fechaVuelta().toString(), viaje.origen(), viaje.destino());
    }

}