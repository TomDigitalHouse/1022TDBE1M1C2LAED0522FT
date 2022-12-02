package com.example.demo.services;

public class BadRequestException extends Exception {
    public BadRequestException() {
        super("Destino no puede ser null");
    }
}
