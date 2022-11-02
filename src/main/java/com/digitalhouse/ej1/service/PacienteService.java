package com.digitalhouse.ej1.service;

import com.digitalhouse.ej1.model.Paciente;
import com.digitalhouse.ej1.repository.DomicilioDAO;
import com.digitalhouse.ej1.repository.PacienteDAO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PacienteService {
    private final PacienteDAO pacienteDAO;
    private final DomicilioDAO domicilioDAO;

    public void darDeAlta(Paciente paciente){
       domicilioDAO.darDeAlta(paciente.domicilio());
       pacienteDAO.darDeAlta(paciente);
    }

    public Paciente buscar(int id){
       var paciente = pacienteDAO.buscar(id);
       var domicilio = domicilioDAO.buscar(paciente.domicilio().id());


       return new Paciente(paciente.id(), paciente.nombre(), paciente.apellido(), paciente.dni(), paciente.fechaIngreso(), domicilio);
    }


    public void eliminar(int id){
        pacienteDAO.eliminar(id);
    }


    public void modificar(Paciente paciente){
        pacienteDAO.modificar(paciente);
        domicilioDAO.modificar(paciente.domicilio());
    }


}
