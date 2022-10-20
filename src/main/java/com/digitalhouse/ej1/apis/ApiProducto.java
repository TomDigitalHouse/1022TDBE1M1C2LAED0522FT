package com.digitalhouse.ej1.apis;

import com.digitalhouse.ej1.model.Producto;

public class ApiProducto {
    public int descuento(Producto unProducto){
        return unProducto.tipo().compareTo("Lata")==0 ? 10 : 0;
    }
}
