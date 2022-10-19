package com.digitalhouse.ej1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Grupo {

    public final List<Persona> personas = new ArrayList<>();

    public void addPersona(final Persona p) throws UnderAgeException, NoTieneSuficentesLetrasExeception {
        if (p.edad() < 18) throw new UnderAgeException();
        if (!tieneSufcientesLetras(p.nombre())) throw new NoTieneSuficentesLetrasExeception();
        personas.add(p);
    }

    private boolean tieneSufcientesLetras(final String name) {
        return name.chars().mapToObj(c -> (char) c).filter(Character::isLetter).count() > 5;
    }
}
