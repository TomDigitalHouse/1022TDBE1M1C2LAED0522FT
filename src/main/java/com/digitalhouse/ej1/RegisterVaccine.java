package com.digitalhouse.ej1;

public class RegisterVaccine implements Register {
    @Override
    public String registrar(Person p) {
       return "Se ha registrado el " + p.dni() + " en la fecha " + p.date() + " como vacunado ";
    }

}
