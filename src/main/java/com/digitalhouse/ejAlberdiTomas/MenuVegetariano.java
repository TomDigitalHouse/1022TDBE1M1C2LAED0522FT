package com.digitalhouse.ejAlberdiTomas;

import lombok.Getter;

@Getter
public class MenuVegetariano extends Menu {
    private final int cantidadSalsas;
    private final Double precioFinal;

    public MenuVegetariano(Double precioBase, int cantidadSalsas) {
        super(precioBase);
        this.cantidadSalsas = cantidadSalsas;
        this.precioFinal = precioBase+((precioBase*1)/100)+(2*cantidadSalsas);
    }
}
