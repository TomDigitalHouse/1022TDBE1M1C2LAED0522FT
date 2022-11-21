package com.example.demo.repository;

import com.example.demo.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
    void deleteByMatricula(int matricula);
    Optional<Odontologo> findByMatricula(int matricula);
}
