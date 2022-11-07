package com.digitalhouse.mesas.ej1.model;

import java.io.Serializable;

public record Contacto(String nombre, String apellido, String mail, String telefono) implements Serializable {
}
