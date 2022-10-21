package com.digitalhouse.ej1;

import model.Persona;

import java.time.LocalDate;

public class RegistrableVacunaProxy implements Registrable {

    private final RegistrableVacuna registrableVacuna = new RegistrableVacuna();

    @Override
    public String vacunar(Persona p) {
        if (laFechaEsPasada(p.fechaAsignada())) return "La fecha es incorrecta";

        return registrableVacuna.vacunar(p);
    }

    private boolean laFechaEsPasada(LocalDate date){
       return date.isBefore(LocalDate.now().minusDays(1));
    }
}
