package com.digitalhouse.mesas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ArbolFactory {
    static Map<String, Arbol> TIPO_ARBOLES = new HashMap<>();

    public static Arbol getTreeType(final String tipoArbol, final int alto, final int ancho, final String color) {
        var arbol = TIPO_ARBOLES.get(tipoArbol);

        if (Objects.nonNull(arbol)) {
            return arbol;
        }

        var newArbol = new Arbol(alto, ancho, color, tipoArbol);
        TIPO_ARBOLES.put(tipoArbol, newArbol);
        return newArbol;
    }
}