package com.example.demo.services;

import com.example.demo.controller.OdontologoNotFound;
import com.example.demo.controller.PacienteNotFound;
import com.example.demo.model.Turno;
import com.example.demo.repository.Dao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TurnoService {

    private final Dao<Turno> dao;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;


    public List<Turno> listar() {
        return dao.getAll();
    }

    public Turno agregar(int id, int pacienteId, int matricula, LocalDate date) throws OdontologoNotFound, PacienteNotFound {
        var odontologo = odontologoService.getByMatricula(matricula).orElseThrow(OdontologoNotFound::new);
        var paciente = pacienteService.getById(pacienteId).orElseThrow(PacienteNotFound::new);
        var turno = new Turno(id, odontologo, paciente, date);
        dao.add(turno);

        return turno;
    }
}
