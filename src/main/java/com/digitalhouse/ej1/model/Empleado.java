package com.digitalhouse.ej1.model;

import java.io.Serializable;

public record Empleado(String nombre, String apellido, String legajo, int sueldo) implements Serializable {
}
