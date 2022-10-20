package com.digitalhouse.ej1.apis;

public class ApiCantidad {
    public int descuento(int cuantos) {
        return cuantos > 11 ? 15 : 0;
    }
}
