package com.digitalhouse.mesas.model;

import java.time.LocalDate;

public record Viaje(LocalDate fechaIda, LocalDate fechaVuelta, String origen, String destino) {
}
