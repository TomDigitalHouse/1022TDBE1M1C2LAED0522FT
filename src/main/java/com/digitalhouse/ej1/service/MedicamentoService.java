package com.digitalhouse.ej1.service;

import com.digitalhouse.ej1.model.Medicamento;
import com.digitalhouse.ej1.repository.MedicamentoDAO;
import com.digitalhouse.ej1.repository.MedicamentoDAOH2;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

@AllArgsConstructor
public class MedicamentoService {
    private final static Logger logger = LogManager.getLogger(MedicamentoDAOH2.class);
    private final MedicamentoDAO medicamentoDAO;
    public void guardar(Medicamento m){
        try {
            medicamentoDAO.guardar(m);
        } catch (SQLException e) {
            logger.fatal("No se pudo guardar el medicamento");
        }
    }



    public void update(Medicamento medicamento){
        try {
            medicamentoDAO.update(medicamento);
        } catch (SQLException e) {
            logger.fatal("Fallo la actualizacion");
        }
    }
}
