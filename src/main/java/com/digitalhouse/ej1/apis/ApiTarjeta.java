package com.digitalhouse.ej1.apis;

import com.digitalhouse.ej1.model.Tarjeta;

public class ApiTarjeta {
    public int descuento(Tarjeta unaTarjeta) {
        return unaTarjeta.banco().compareTo("Star Bank")==0 ? 10 : 0;
    }
}
