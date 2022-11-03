package com.digitalhouse.ej1.repository;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    void darDeAlta(T t);

    Optional<T> buscar(int id);

    void eliminar(int id);

    void modificar(T t);

    List<T> getAll();
}
