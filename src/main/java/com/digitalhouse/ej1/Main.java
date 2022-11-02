package com.digitalhouse.ej1;

import com.digitalhouse.ej1.model.Domicilio;
import com.digitalhouse.ej1.model.Paciente;
import com.digitalhouse.ej1.repository.DomicilioDAO;
import com.digitalhouse.ej1.repository.PacienteDAO;
import com.digitalhouse.ej1.service.PacienteService;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";

    public static void main(String[] args) throws IOException {
        startLogger();

        var service = new PacienteService(new PacienteDAO(), new DomicilioDAO());
        var paciente = new Paciente(1, "nombre", "appellido", "123123", LocalDate.now(),
                new Domicilio(1, "calle", 1, "localida", "proviuncia"));
        service.buscar(paciente.id());



    }


    private static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }
}
