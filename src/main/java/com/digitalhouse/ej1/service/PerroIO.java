package com.digitalhouse.ej1.service;

import com.digitalhouse.ej1.model.Perro;

import java.io.*;
import java.util.List;

public class PerroIO {

    private static final String FILENAME = "perros.dat";

    public static void write(List<Perro> perros) {
        try (var fo = new FileOutputStream(FILENAME); var objStream = new ObjectOutputStream(fo)) {
            objStream.writeObject(perros);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Perro> read() throws IOException, ClassNotFoundException {
        try (var fi = new FileInputStream(FILENAME); var objStream = new ObjectInputStream(fi)) {
            return (List<Perro>) objStream.readObject();
        }
    }
}
