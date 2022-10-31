package com.digitalhouse.ej1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";

    private final static String DROP = "DROP TABLE IF EXISTS CUENTAS;";

    private final static String CREATE = "CREATE TABLE CUENTAS (ID INT PRIMARY KEY AUTO_INCREMENT, NOMBRE VARCHAR, NRO_CUENTA VARCHAR, SALDO NUMBER);";

    private final static String UPDATE_SALDO = "UPDATE CUENTAS SET SALDO = ? WHERE id = ?";

    private final static String INSERT = "INSERT INTO CUENTAS (NOMBRE, NRO_CUENTA, SALDO) VALUES (?,?,?)";

    private final static String SELECT_ALL = "SELECT * FROM CUENTAS;";

    public static void main(String[] args) throws IOException, SQLException {
        startLogger();

        var cuenta = new Cuenta(1, 100, "Sueldo", 0);

        create();
        insert(cuenta);
        //update(cuenta);
        //updateWithTX(cuenta);

        updateWithStatement(cuenta);

        mostrarResultados();


    }

    private static void create() throws SQLException {
        var connection = getConnection();
        var create = connection.createStatement();
        create.execute(DROP + CREATE);
    }

    private static void insert(Cuenta cuenta) throws SQLException {
        var connection = getConnection();
        var insert = connection.prepareStatement(INSERT);

        insert.setString(1, cuenta.nombre());
        insert.setInt(2, cuenta.nroCuenta());
        insert.setDouble(3, cuenta.saldo());

        insert.execute();
    }

    private static void update(Cuenta cuenta) throws SQLException {
        var connection = getConnection();
        var update = connection.prepareStatement(UPDATE_SALDO);
        update.setDouble(1, cuenta.saldo() + 10.0);
        update.setInt(2, cuenta.id());

        update.executeUpdate();
    }

    private static void updateWithStatement(Cuenta cuenta) throws SQLException {
        var saldo = cuenta.saldo();
        var fakeId = "1; DROP TABLE CUENTAS";

        var UPDATE_SALDO = "UPDATE CUENTAS SET SALDO = "+saldo +" WHERE id = "+fakeId;

        var connection = getConnection();
        var update = connection.createStatement();
        update.executeUpdate(UPDATE_SALDO);
    }

    private static void updateWithTX(Cuenta cuenta) throws SQLException {
        Connection connection = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);


            var update = connection.prepareStatement(UPDATE_SALDO);
            update.setDouble(1, cuenta.saldo() + 15.0);
            update.setInt(2, cuenta.id());

            var i = 1/0;

            update.executeUpdate();

            connection.commit();

        } catch (SQLException | ArithmeticException e) {
            if (connection != null) {
                connection.rollback();
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void mostrarResultados() throws SQLException {
        var connection = getConnection();
        var statement = connection.createStatement();
        var result = statement.executeQuery(SELECT_ALL);

        while (result.next()){
            logger.info("ID: "+result.getInt(1)+ "NOMBRE: "+result.getString(2)+" NRO_CUENTA: "+result.getInt(3)+" SALDO: "+ result.getDouble(4));
        }
    }


    private static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/clase13");
    }
}
