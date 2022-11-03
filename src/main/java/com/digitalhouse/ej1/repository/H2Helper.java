package com.digitalhouse.ej1.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class H2Helper {
    private final static String DB_URL = "jdbc:h2:~/dbClinica4;INIT=RUNSCRIPT FROM 'create2.sql'";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
