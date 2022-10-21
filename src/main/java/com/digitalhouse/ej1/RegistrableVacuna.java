package com.digitalhouse.ej1;

import model.Persona;

public class RegistrableVacuna implements Registrable {
    public String vacunar(Persona p) {
        return "La persona "+p.name()+" "+p.surname()+ "fue vacunada el dia "+p.fechaAsignada()+ "con la vacuna "+p.vacuna();
    }
}
