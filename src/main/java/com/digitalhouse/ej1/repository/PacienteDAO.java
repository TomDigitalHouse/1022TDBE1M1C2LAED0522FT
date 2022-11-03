package com.digitalhouse.ej1.repository;

import com.digitalhouse.ej1.model.Domicilio;
import com.digitalhouse.ej1.model.Paciente;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PacienteDAO implements Dao<Paciente> {
    private final static String SELECT_ID = "SELECT * FROM pacientes WHERE id = ?";
    private final static String SELECT = "SELECT * FROM pacientes";
    private final static String INSERT = "INSERT INTO pacientes(id,nombre,dni,ingreso,domicilio_id) VALUES(?,?,?,?,?)";
    private final static String UPDATE = "UPDATE pacientes set nombre = ?, dni = ?, ingreso = ?, domicilio_id = ? where id = ?";
    private final static String DELETE = "DELETE FROM pacientes WHERE id = ?";

    @Override
    public void darDeAlta(Paciente paciente) {
        try (var connection = H2Helper.getConnection()) {
            var buscar = connection.prepareStatement(INSERT);
            buscar.setInt(1, paciente.id());
            buscar.setString(2, paciente.nombre());
            buscar.setString(3, paciente.dni());
            buscar.setDate(4, Date.valueOf(paciente.fechaIngreso()));
            buscar.setInt(5, paciente.domicilio().id());

            buscar.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Paciente> buscar(int id) {
        try (var connection = H2Helper.getConnection()) {
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

                return Optional.of(new Paciente(id, nombre, apellido, dni, fechaIngreso.toLocalDate(),
                        new Domicilio(domicilioId, null, 0, null, null)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(int id) {
        try (var connection = H2Helper.getConnection()) {
            var update = connection.prepareStatement(DELETE);
            update.setInt(1, id);

            update.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modificar(Paciente paciente) {
        try (var connection = H2Helper.getConnection()) {
            var update = connection.prepareStatement(UPDATE);
            update.setString(1, paciente.nombre());
            update.setString(2, paciente.dni());
            update.setDate(3, Date.valueOf(paciente.fechaIngreso()));
            update.setInt(4, paciente.domicilio().id());
            update.setInt(5, paciente.id());

            update.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Paciente> getAll() {
        var lista = new ArrayList<Paciente>();
        try (var connection = H2Helper.getConnection()) {
            var buscar = connection.prepareStatement(SELECT);
            var result = buscar.executeQuery();
            while (result.next()) {
                var id = result.getInt(1);
                var nombre = result.getString(2);
                var apellido = result.getString(3);
                var dni = result.getString(4);
                var fechaIngreso = result.getDate(5);
                var domicilioId = result.getInt(6);

                lista.add(
                        new Paciente(id, nombre, apellido, dni, fechaIngreso.toLocalDate(),
                                new Domicilio(domicilioId, null, 0, null, null)));
;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}

