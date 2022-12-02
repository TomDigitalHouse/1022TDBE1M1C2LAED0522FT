package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Paquete(long id, String codigo, String nombreProducto, Estado estado, Destino destino) {
}
