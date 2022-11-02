package com.digitalhouse.ej1.repository;

import com.digitalhouse.ej1.model.Medicamento;

import java.sql.SQLException;

public interface MedicamentoDAO {
        void guardar(Medicamento m) throws SQLException;
        Medicamento buscar(int id);
        void update(Medicamento m) throws SQLException;
}
