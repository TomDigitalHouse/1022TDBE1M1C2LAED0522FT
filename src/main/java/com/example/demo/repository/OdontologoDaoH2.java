package com.example.demo.repository;

import com.example.demo.model.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.repository.H2Manager.getConnection;

@Repository
public class OdontologoDaoH2 implements Dao<Odontologo> {

    private static final Logger logger = LogManager.getLogger(OdontologoDaoH2.class);
    private static final String INSERT = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?);";
    private static final String UPDATE = "UPDATE ODONTOLOGOS SET NOMBRE = ?, APELLIDO = ?  WHERE MATRICULA = ?;";

    private static final String SELECT_ALL = "SELECT * FROM ODONTOLOGOS;";

    private static final String SELECT_BY_MATRICULA = "SELECT * FROM ODONTOLOGOS WHERE matricula = ?;";

    private static final String DELETE = "DELETE FROM ODONTOLOGOS WHERE MATRICULA = ?;";

    @Override
    public List<Odontologo> getAll() {
        var odontologos = new ArrayList<Odontologo>();
        try (var connection = getConnection()) {
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                logger.info(" matricula: " + resultSet.getInt(1) + " nombre: " + resultSet.getString(2) + " apellido " + resultSet.getString(3));
                odontologos.add(new Odontologo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
            if (odontologos.size() == 0) logger.info("no hay odontologos en la lista");

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return odontologos;
    }

    @Override
    public void add(Odontologo odontologo) {
        try (var connection = getConnection()) {
            var agregar = connection.prepareStatement(INSERT);

            agregar.setInt(1, odontologo.matricula());
            agregar.setString(2, odontologo.nombre());
            agregar.setString(3, odontologo.apellido());

            agregar.execute();
            logger.info("Se agrego correctamente a la base de datos!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void update(Odontologo odontologo) {
        try (var connection = getConnection()) {
            var psUpdate = connection.prepareStatement(UPDATE);
            psUpdate.setString(1, odontologo.nombre());
            psUpdate.setString(2, odontologo.apellido());
            psUpdate.setInt(3, odontologo.matricula());

            psUpdate.execute();
            logger.info("Se modifico correctamente!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(int matricula) {
        try (var connection = getConnection()) {
            var eliminar = connection.prepareStatement(DELETE);
            eliminar.setInt(1, matricula);
            eliminar.executeQuery();
            logger.info("se eliminó correctamente!");

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

    }

    @Override
    public Optional<Odontologo> getByMatricula(int matricula) {
        try (var connection = getConnection()) {
            var statement = connection.prepareStatement(SELECT_BY_MATRICULA);
            statement.setInt(1, matricula);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                logger.info(" matricula: " + resultSet.getInt(1) + " nombre: " + resultSet.getString(2) + " apellido " + resultSet.getString(3));
                return Optional.of (new Odontologo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return Optional.empty();
    }
}
