package com.example.demo.repository;


import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> getAll();

    void add(T entidad);

    void update(T entidad);

    void delete(int id);

    Optional<T> getByMatricula(int id);

}