package com.digitalhouse.ej1;

import com.digitalhouse.ej1.apis.ApiCantidad;
import com.digitalhouse.ej1.apis.ApiProducto;
import com.digitalhouse.ej1.apis.ApiTarjeta;
import com.digitalhouse.ej1.model.Producto;
import com.digitalhouse.ej1.model.Tarjeta;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FacadeDescuento {
    private final ApiTarjeta apiTarjeta;
    private final ApiProducto apiProducto;
    private final ApiCantidad apiCantidad;

    public int descuento(Tarjeta tarj, Producto prod, int cant) {
        return apiCantidad.descuento(cant) + apiProducto.descuento(prod) + apiTarjeta.descuento(tarj);
    }

}
