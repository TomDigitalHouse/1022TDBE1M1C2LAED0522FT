package com.digitalhouse.ej1;

import com.digitalhouse.ej1.model.Empleado;
import com.digitalhouse.ej1.model.Empresa;
import com.digitalhouse.ej1.service.EmpresasIO;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        startLogger();




        var empleado1= new Empleado("nombre", "ape", "asdasd", 500);
        var empleado2= new Empleado("asdasd", "fgfg", "asdasd", 343);
        var empleado3= new Empleado("asdas", "fdfg", "asdasd", 2342);
        var empleado4= new Empleado("asdsad", "fgfg", "asdasd", 23432);

        var empresa = new Empresa("54545","digital house", Arrays.asList(empleado1, empleado2, empleado3, empleado4));

        EmpresasIO.writeToDAT(empresa);


        EmpresasIO.writeToCSV(empresa);
       // EmpresasIO.read().empleados().forEach(System.out::println);
    }

    private static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }
}
