package com.digitalhouse.ej1.repository;

import com.digitalhouse.ej1.model.Domicilio;
import com.digitalhouse.ej1.model.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DomicilioDAO implements Dao<Domicilio> {
    private final static Logger logger = LogManager.getLogger(DomicilioDAO.class);
    private final static String SELECT_ID = "SELECT * FROM domicilio WHERE id = ?";
    private final static String SELECT = "SELECT * FROM domicilio";

    private final static String INSERT = "INSERT INTO domicilio(id,calle,numero,localidad,provincia) VALUES(?,?,?,?,?)";
    private final static String UPDATE = "UPDATE domicilio set calle = ?, numero = ?, localidad = ?, provincia = ? where id = ?";


    @Override
    public void darDeAlta(Domicilio domicilio) {
        try (var connection = H2Helper.getConnection()) {
            var buscar = connection.prepareStatement(INSERT);
            buscar.setInt(1, domicilio.id());
            buscar.setString(2, domicilio.calle());
            buscar.setInt(3, domicilio.numero());
            buscar.setString(4, domicilio.localidad());
            buscar.setString(5, domicilio.provincia());

            buscar.execute();
            logger.debug("Domicilio agregado");
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Domicilio> buscar(int id) {
        try (var connection = H2Helper.getConnection()) {
            var buscar = connection.prepareStatement(SELECT_ID);
            buscar.setInt(1, id);

            var result = buscar.executeQuery();

            if (result.next()) {
                connection.close();
                var calle = result.getString(2);
                var numero = result.getInt(3);
                var localidad = result.getString(4);
                var provincia = result.getString(5);
                logger.debug("Domicilio encontrado");
                return Optional.of(new Domicilio(id, calle, numero, localidad, provincia));
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
        logger.debug("Domicilio no encontrado");
        return Optional.empty();
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void modificar(Domicilio domicilio) {
        try (var connection = H2Helper.getConnection()) {
            var update = connection.prepareStatement(UPDATE);
            update.setString(1, domicilio.calle());
            update.setInt(2, domicilio.numero());
            update.setString(3, domicilio.localidad());
            update.setString(4, domicilio.provincia());
            update.setInt(5, domicilio.id());

            update.executeUpdate();
            logger.debug("Domicilio actualizado");
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Domicilio> getAll() {
        var lista = new ArrayList<Domicilio>();
        try (var connection = H2Helper.getConnection()) {
            var buscar = connection.prepareStatement(SELECT);
            var result = buscar.executeQuery();
            while (result.next()) {
                var id = result.getInt(1);
                var calle = result.getString(2);
                var numero = result.getInt(3);
                var localidad = result.getString(4);
                var provincia = result.getString(5);

                lista.add(new Domicilio(id, calle, numero, localidad, provincia));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
