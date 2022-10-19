package com.digitalhouse.ejAlberdiTomas;

import lombok.Getter;

@Getter
public class MenuClasico extends Menu{
    private final Double precioFinal;

    public MenuClasico(Double precioBase) {
        super(precioBase);
        this.precioFinal = precioBase;
    }
}
