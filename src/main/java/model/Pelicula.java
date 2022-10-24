package model;

import java.util.EnumSet;

public record Pelicula(String nombre, EnumSet<Pais> paises, String link) {
}
