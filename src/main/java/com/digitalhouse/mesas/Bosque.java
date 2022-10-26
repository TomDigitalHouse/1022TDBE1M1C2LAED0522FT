package com.digitalhouse.mesas;

import java.util.ArrayList;
import java.util.List;

public class Bosque {

    private static final List<Arbol> ARBOL = new ArrayList<>();

    public void plantarArbol(final String tipoArbol, final int alto, final int ancho, final String color) {
        var arbol = ArbolFactory.getTreeType(tipoArbol, alto, ancho, color);
        ARBOL.add(arbol);
    }
}