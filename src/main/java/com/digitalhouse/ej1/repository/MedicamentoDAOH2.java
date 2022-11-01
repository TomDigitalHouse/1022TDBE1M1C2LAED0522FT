package com.digitalhouse.ej1.repository;

import com.digitalhouse.ej1.model.Medicamento;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MedicamentoDAOH2 implements MedicamentoDAO {
    private final static String DB_URL = "jdbc:h2:~/db_farmacia2;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String INSERT = "INSERT INTO medicamentos(nombre,laboratorio,cantidad,precio) VALUES(?,?,?,?)";
    private final static String SELECT = "SELECT id,nombre,laboratorio,cantidad,precio  FROM medicamentos where id = ?";
    private final static Logger logger = LogManager.getLogger(MedicamentoDAOH2.class);


    @Override
    public void guardar(Medicamento m) throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            var insert = connection.prepareStatement(INSERT);
            insert.setString(1, m.nombre());
            insert.setString(2, m.labo());
            insert.setInt(3, m.cantidad());
            insert.setDouble(4, m.precio());

            insert.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }



    @Override
    public void update(Medicamento m) throws SQLException {
        var connection = getConnection();
        var update = connection.prepareStatement("UPDATE medicamentos set nombre = ? where id = ?");
        update.setString(1, m.nombre());
        update.setInt(2, m.id());

        update.executeUpdate();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

}
