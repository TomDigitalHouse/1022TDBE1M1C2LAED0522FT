package com.digitalhouse.ej1.service;

import com.digitalhouse.ej1.model.Paciente;
import com.digitalhouse.ej1.repository.DomicilioDAO;
import com.digitalhouse.ej1.repository.PacienteDAO;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class PacienteService {
    private final PacienteDAO pacienteDAO;
    private final DomicilioDAO domicilioDAO;

    public void darDeAlta(Paciente paciente) {
        domicilioDAO.darDeAlta(paciente.domicilio());
        pacienteDAO.darDeAlta(paciente);
    }

    public Optional<Paciente> buscar(int id) {
        var paciente = pacienteDAO.buscar(id);

        if (paciente.isPresent()) {
            var newPaciente = paciente.get();
            var domicilio = domicilioDAO.buscar(newPaciente.domicilio().id()).orElseThrow();
            return Optional.of(new Paciente(
                    newPaciente.id(),
                    newPaciente.nombre(),
                    newPaciente.apellido(),
                    newPaciente.dni(),
                    newPaciente.fechaIngreso(),
                    domicilio
            ));
        }
        return Optional.empty();
    }

    public void eliminar(int id) {
        pacienteDAO.eliminar(id);
    }

    public void modificar(Paciente paciente) {
        pacienteDAO.modificar(paciente);
        domicilioDAO.modificar(paciente.domicilio());
    }
}
