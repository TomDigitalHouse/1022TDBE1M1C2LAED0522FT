package com.digitalhouse.ej1.factory;

import com.digitalhouse.ej1.model.Computadora;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    public static final Map<String, Computadora> macLigeros = new HashMap<>();

    public Computadora getComputer(int ram, int disco) {

        var clave = "key:" + ram + ":" + disco;

        System.out.println(clave);

        if (!macLigeros.containsKey(clave)) {
            macLigeros.put(clave, new Computadora(ram, disco));
            System.out.println("PC creada");
            return macLigeros.get(clave);

        }
        System.out.println("PC obtenida");

        return macLigeros.get(clave);
    }
}
