package com.digitalhouse.ej1;

import com.digitalhouse.ej1.apis.ApiCantidad;
import com.digitalhouse.ej1.apis.ApiProducto;
import com.digitalhouse.ej1.apis.ApiTarjeta;
import com.digitalhouse.ej1.model.Producto;
import com.digitalhouse.ej1.model.Tarjeta;

public class FacadeDescuento {
    private final ApiTarjeta apiTarjeta = new ApiTarjeta();
    private final ApiProducto apiProducto = new ApiProducto();
    private final ApiCantidad apiCantidad = new ApiCantidad();

    public int descuento(Tarjeta tarj, Producto prod, int cant) {
        return apiCantidad.descuento(cant) +  apiProducto.descuento(prod)+ apiTarjeta.descuento(tarj);
    }

}
