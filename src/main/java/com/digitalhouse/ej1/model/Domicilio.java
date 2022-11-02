package com.digitalhouse.ej1.model;

import java.time.LocalDate;

public record Domicilio(int id, String calle, int numero, String localidad, String provincia) {
}
