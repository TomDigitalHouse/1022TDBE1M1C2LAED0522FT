package com.example.demo.services;

import com.example.demo.exceptions.OdontologoNotFound;
import com.example.demo.exceptions.PacienteNotFound;
import com.example.demo.model.Odontologo;
import com.example.demo.model.Paciente;
import com.example.demo.model.Turno;
import com.example.demo.repository.TurnoDaoH2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class TurnoServiceTest {

    @Test
    @DisplayName("")
    public void test1() {
        //GIVEN
        var turnoDao = mock(TurnoDaoH2.class);
        var odontologoDao = mock(OdontologoService.class);
        when(odontologoDao.getByMatricula(anyInt())).thenReturn(Optional.empty());
        var pacienteDao = mock(PacienteService.class);
        var service = new TurnoService(turnoDao, pacienteDao, odontologoDao);
        var turno = new Turno(1,
                new Odontologo(1, null, null),
                new Paciente(1, null, null, null, null, null),
                LocalDate.now());
        //THEN
        assertThrows(OdontologoNotFound.class, () -> service.agregar(turno));
    }

    @Test
    @DisplayName("WHEM agregar is called with a right paciente/odontolgo THEN adds a new turno")
    public void test2() throws OdontologoNotFound, PacienteNotFound {
        //GIVEN
        var turnoDao = mock(TurnoDaoH2.class);
        var odontologoDao = mock(OdontologoService.class);
        when(odontologoDao.getByMatricula(anyInt())).thenReturn(Optional.of(providesOdontologo()));
        var pacienteDao = mock(PacienteService.class);
        when(pacienteDao.getById(anyInt())).thenReturn(Optional.of(providesPaciente()));
        var service = new TurnoService(turnoDao, pacienteDao, odontologoDao);
        var turno = new Turno(1,
                providesOdontologo(),
                providesPaciente(),
                LocalDate.now());
        //WHEN
        service.agregar(turno);
        //THEN
        verify(turnoDao).add(turno);
    }

    private Paciente providesPaciente() {
        return new Paciente(1, null, null, null, null, null);
    }

    private Odontologo providesOdontologo() {
        return new Odontologo(1, null, null);
    }

}