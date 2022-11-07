package com.digitalhouse.mesas.ej1;

import com.digitalhouse.ej1.model.Perro;
import com.digitalhouse.ej1.service.PerroIO;
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

        PerroIO.write(Arrays.asList(new Perro("perro1", 5), new Perro("perro2", 8)));

        PerroIO.read().forEach(System.out::println);
    }

    private static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }
}
