package com.example.demo.services;

import com.example.demo.model.Alumno;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.repository.ProfesorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AlumnoService {
    private final AlumnoRepository repository;
    private final ProfesorRepository profesorRepository;

    @Transactional
    public List<Alumno> addAlumnos(Set<Alumno> alumnos, long profesorId) {
        var profesor = profesorRepository.findById(profesorId).orElseThrow();
        alumnos.forEach(alumno -> alumno.setProfesor(profesor));
        return repository.saveAll(alumnos);
    }

    public List<Alumno> getAll() {
        return repository.findAll();
    }
}
