package com.example.demo.services;

import com.example.demo.repository.AlumnoRepository;
import com.example.demo.repository.ProfesorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlumnoService {
    private final AlumnoRepository repository;

}
