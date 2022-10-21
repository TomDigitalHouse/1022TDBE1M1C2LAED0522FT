package model;

import java.time.LocalDate;

public record Persona(String name, String surname, String dni, String vacuna, LocalDate fechaAsignada) {
}
