package com.example.demo.repository;


import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    void add(T entidad);

    void update(T entidad);

    void delete(int id);

}