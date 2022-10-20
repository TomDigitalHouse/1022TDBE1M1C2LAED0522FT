package com.digitalhouse.ej1;

import lombok.SneakyThrows;

import java.util.Date;

public class RegisterVaccineProxy implements Register {
    @SneakyThrows
    @Override
    public String registrar(Person person) {
        if (comprobarFecha(person.date())) throw new Exception();

        var register = new RegisterVaccine();
        return register.registrar(person);
    }

    private boolean comprobarFecha(Date fecha) {
        return fecha.before(new Date());
    }
}
