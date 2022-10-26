package com.digitalhouse.mesas.facade;

import com.digitalhouse.mesas.apis.AvionAPI;
import com.digitalhouse.mesas.apis.HotelAPI;
import com.digitalhouse.mesas.model.Viaje;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class CheckFacade {
	private final AvionAPI avionAPI;
	private final HotelAPI hotelAPI;

	public void buscar(String fechaIda, String fechaVuelta, String origen, String destino) {
		avionAPI.buscarVuelos(fechaIda, fechaVuelta, origen, destino);
		hotelAPI.buscarHoteles(fechaIda, fechaVuelta, destino);
	}
	//SOLO A MODO DE EJEMPLO
	public void buscar(Viaje viaje) {
		avionAPI.buscarVuelosConViaje(viaje);
		hotelAPI.buscarHotelesConViaje(viaje);
	}

}
