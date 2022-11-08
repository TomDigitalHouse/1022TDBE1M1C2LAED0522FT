package com.digitalhouse.ej1.model;

import java.io.Serializable;
import java.util.List;

public record Empresa(String cuit, String razonSocial, List<Empleado> empleados) implements Serializable {
}
