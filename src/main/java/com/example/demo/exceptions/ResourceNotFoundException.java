package com.example.demo.exceptions;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException() {
        super("No se encontro el recurso");
    }
}
