package com.digitalhouse.ej1;

import model.Persona;

public class RegistrableVacuna implements Registrable {
    @Override
    public String registrar(Persona p) {
       return "Se ha registrado el " + p.dni() + " en la fecha " + p.date() + " como vacunado ";
    }

}
