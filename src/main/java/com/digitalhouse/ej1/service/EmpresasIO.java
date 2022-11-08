package com.digitalhouse.ej1.service;

import com.digitalhouse.ej1.model.Empleado;
import com.digitalhouse.ej1.model.Empresa;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmpresasIO {

    private static final String FILENAME = "empresas.dat";
    private static final String FILENAME_CSV = "empresas.txt";

    public static void writeToDAT(Empresa empresa) {
        try (var fo = new FileOutputStream(FILENAME); var objStream = new ObjectOutputStream(fo)) {
            objStream.writeObject(empresa);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToCSV(Empresa empresa) {
        try (var fo = new FileOutputStream(FILENAME_CSV); var printWriter = new PrintWriter(fo)) {
            empresa.empleados().stream().map(EmpresasIO::getCSV).forEach(printWriter::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Empresa read() throws IOException, ClassNotFoundException {
        try (var fi = new FileInputStream(FILENAME); var objStream = new ObjectInputStream(fi)) {
            return (Empresa) objStream.readObject();
        }
    }

    private static String getCSV(Empleado e) {
        return e.nombre() + "," + e.apellido() + "," + e.legajo() + "," + e.sueldo();
    }

}
