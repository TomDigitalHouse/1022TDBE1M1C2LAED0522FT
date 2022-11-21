package com.example.demo.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class H2Manager {
    private static final String SQL_FILE = "src/main/resources/create.sql";
    private static final String DB_URL = "jdbc:h2:~/proyectoIntegrador;INIT=RUNSCRIPT FROM "+SQL_FILE;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
