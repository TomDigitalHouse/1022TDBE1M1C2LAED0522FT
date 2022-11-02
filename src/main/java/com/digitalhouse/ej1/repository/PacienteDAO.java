package com.digitalhouse.ej1.repository;

import com.digitalhouse.ej1.model.Domicilio;
import com.digitalhouse.ej1.model.Paciente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PacienteDAO implements Dao<Paciente> {

    private final static String DB_URL = "jdbc:h2:~/db_clinica;INIT=RUNSCRIPT FROM 'create2.sql'";
    private final static String SELECT_ID = "SELECT * FROM pacientes WHERE id = ?";

    @Override
    public Paciente darDeAlta(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente buscar(int id) {
        try {
            var connection = getConnection();
            var buscar = connection.prepareStatement(SELECT_ID);
            buscar.setInt(1, id);
            var result = buscar.executeQuery();

            if (result.next()) {
                connection.close();
                var nombre = result.getString(2);
                var apellido = result.getString(3);
                var dni = result.getString(4);
                var fechaIngreso = result.getDate(5);
                var domicilioId = result.getInt(6);

                return new Paciente(id, nombre, apellido, dni, fechaIngreso.toLocalDate(), new Domicilio(domicilioId, null, 0, null, null));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void modificar(Paciente paciente) {

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, "", "");
    }
}
