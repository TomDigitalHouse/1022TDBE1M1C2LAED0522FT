package com.digitalhouse.ej1;

import model.Persona;

import java.time.LocalDate;

public class RegistrableVacunaProxy implements Registrable {
    public static final LocalDate MAX_DATE = LocalDate.now().plusDays(5);

    @Override
    public String registrar(Persona persona) throws OldDateException {
        if (comprobarFecha(persona.date())) throw new OldDateException();

        var register = new RegistrableVacuna();
        return register.registrar(persona);
    }

    private boolean comprobarFecha(LocalDate fecha) {
        return fecha.isBefore(MAX_DATE);
    }
}
