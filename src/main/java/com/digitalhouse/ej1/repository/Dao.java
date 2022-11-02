package com.digitalhouse.ej1.repository;

public interface Dao<T> {
    T darDeAlta(T t);
    T buscar(int id);
    void eliminar(int id);
    void modificar(T t);
}
