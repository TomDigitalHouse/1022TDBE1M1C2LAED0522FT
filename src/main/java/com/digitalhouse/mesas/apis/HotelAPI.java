package com.digitalhouse.mesas.apis;

import com.digitalhouse.mesas.model.Viaje;

public class HotelAPI {
    public void buscarHoteles(String fechaEntrada, String fechaSalida, String ciudad) {
        System.out.println("==============================");
        System.out.println("Hoteles encontrados : " + ciudad);
        System.out.println("Entrada: " + fechaEntrada + " Salida: " + fechaSalida);
        System.out.println("......");
        System.out.println("......");
        System.out.println("==============================");
    }

    //A MODO DE EJEMPLO
    public void buscarHotelesConViaje(Viaje viaje) {
        buscarHoteles(viaje.fechaIda().toString(), viaje.fechaVuelta().toString(), viaje.destino());
    }
}
