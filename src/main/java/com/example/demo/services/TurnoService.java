package com.example.demo.services;

import com.example.demo.exceptions.OdontologoNotFound;
import com.example.demo.exceptions.PacienteNotFound;
import com.example.demo.model.Turno;
import com.example.demo.repository.Dao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public Turno agregar(Turno turno) throws OdontologoNotFound, PacienteNotFound {
        var odontologo = odontologoService.getByMatricula(turno.odontologo().getMatricula()).orElseThrow(OdontologoNotFound::new);
        var paciente = pacienteService.getById(turno.paciente().id()).orElseThrow(PacienteNotFound::new);
        var newTurno = new Turno(turno.id(), odontologo, paciente, turno.fecha());
        dao.add(newTurno);

        return newTurno;
    }
}
