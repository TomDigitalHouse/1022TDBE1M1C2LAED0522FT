package com.digitalhouse.mesas.apis;

import com.digitalhouse.mesas.model.Viaje;

public class AvionAPI {
    public void buscarVuelos(String fechaIda, String fechaVuelta, String origen, String destino) {
        System.out.println("==============================");
        System.out.println("Vuelos encontrados para " + destino + " desde " + origen);
        System.out.println("Fecha IDA: " + fechaIda + " Fecha Vuelta " + fechaVuelta);
        System.out.println("......");
        System.out.println("......");
        System.out.println("==============================");
    }
//A MODO DE EJEMPLO
    public void buscarVuelosConViaje(Viaje viaje) {
		buscarVuelos(viaje.fechaIda().toString(), viaje.fechaVuelta().toString(), viaje.origen(), viaje.destino());
    }


}
