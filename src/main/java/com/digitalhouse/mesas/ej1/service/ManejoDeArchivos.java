package com.digitalhouse.mesas.ej1.service;

import com.digitalhouse.mesas.ej1.model.Contacto;

import java.io.*;
import java.util.List;

public class ManejoDeArchivos {

    private static final String FILENAME = "contactos.txt";

    public static void write(List<Contacto> perros) {
        try (var fo = new FileOutputStream(FILENAME); var objStream = new ObjectOutputStream(fo)) {
            objStream.writeObject(perros);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Contacto> read() throws IOException, ClassNotFoundException {
        try (var fi = new FileInputStream(FILENAME); var objStream = new ObjectInputStream(fi)) {
            return (List<Contacto>) objStream.readObject();
        }
    }
}
