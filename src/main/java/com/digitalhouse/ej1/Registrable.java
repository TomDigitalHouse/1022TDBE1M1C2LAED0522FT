package com.digitalhouse.ej1;

import model.Persona;

public interface Registrable {
    String registrar(Persona persona) throws OldDateException;
}
