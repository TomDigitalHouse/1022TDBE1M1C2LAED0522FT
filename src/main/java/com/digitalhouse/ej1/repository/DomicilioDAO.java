package com.digitalhouse.ej1.repository;

import com.digitalhouse.ej1.model.Domicilio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DomicilioDAO implements Dao<Domicilio> {

    private final static String DB_URL = "jdbc:h2:~/db_clinica;INIT=RUNSCRIPT FROM 'create2.sql'";
    private final static String SELECT_ID = "SELECT * FROM domicilio WHERE id = ?";

    @Override
    public Domicilio darDeAlta(Domicilio domicilio) {
        return null;
    }

    @Override
    public Domicilio buscar(int id) {
        try {
            var connection = getConnection();
            var buscar = connection.prepareStatement(SELECT_ID);
            buscar.setInt(1, id);
            var result = buscar.executeQuery();

            if (result.next()) {
                connection.close();
                var calle = result.getString(2);
                var numero = result.getInt(3);
                var localidad = result.getString(4);
                var provincia = result.getString(5);

                return new Domicilio(id, calle, numero, localidad, provincia);
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
    public void modificar(Domicilio domicilio) {

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
