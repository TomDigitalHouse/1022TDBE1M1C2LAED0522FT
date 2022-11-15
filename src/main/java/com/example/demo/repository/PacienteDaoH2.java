package com.example.demo.repository;


import com.example.demo.model.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.repository.H2Manager.getConnection;

@Repository
public class PacienteDaoH2 implements Dao<Paciente> {
    private static final Logger logger = LogManager.getLogger(PacienteDaoH2.class);

    private static final String INSERT = "INSERT INTO PACIENTES (ID, NOMBRE, APELLIDO, DOMICILIO , DNI, FECHAALTA) VALUES (?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE PACIENTES SET NOMBRE = ?, APELLIDO = ?, DOMICILIO = ?, DNI = ?, FECHAALTA = ? WHERE ID = ?;";

    private static final String SELECT_ALL = "SELECT * FROM PACIENTES;";

    private static final String DELETE = "DELETE FROM PACIENTES WHERE ID = ?;";

    @Override
    public List<Paciente> getAll() {
        var pacientes = new ArrayList<Paciente>();
        try (var connection = getConnection()) {
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                logger.info("id: " + resultSet.getInt(1) + " nombre: " + resultSet.getString(2) + " apellido: " + resultSet.getString(3) + " domicilio: " + resultSet.getString(4) + " dni: " + resultSet.getString(5) + " fecha de alta: " + resultSet.getDate(6));
                pacientes.add(new Paciente(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6)));
            }
            if (pacientes.size() == 0) logger.info("no hay pacientes en la lista");

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return pacientes;
    }

    @Override
    public void add(Paciente paciente) {

        try (var connection = getConnection()) {
            var agregar = connection.prepareStatement(INSERT);
            agregar.setInt(1, paciente.id());
            agregar.setString(2, paciente.nombre());
            agregar.setString(3, paciente.apellido());
            agregar.setString(4, paciente.domicilio());
            agregar.setString(5, paciente.dni());
            agregar.setDate(6, paciente.fechaAlta());

            agregar.execute();
            logger.info("Se agrego correctamente a la base de datos!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void update(Paciente paciente) {
        try (var connection = getConnection()) {
            var update = connection.prepareStatement(UPDATE);
            update.setString(1, paciente.nombre());
            update.setString(2, paciente.apellido());
            update.setString(3, paciente.domicilio());
            update.setString(4, paciente.dni());
            update.setDate(5, paciente.fechaAlta());
            update.setInt(6, paciente.id());

            update.executeUpdate();
            logger.info("Se modifico correctamente!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try (var connection = getConnection()) {
            var eliminar = connection.prepareStatement(DELETE);

            var selectQuery = "SELECT * FROM PACIENTES WHERE id = ?;";
            var empQuery = connection.prepareStatement(selectQuery);
            empQuery.setInt(1, id);
            var resultSet = empQuery.executeQuery();
            eliminar.setInt(1, id);
            eliminar.execute();
            logger.info("se eliminó correctamente!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Optional<Paciente> getByMatricula(int id) {
        return Optional.empty();
    }
}
