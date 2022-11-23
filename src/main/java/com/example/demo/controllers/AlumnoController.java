package com.example.demo.controllers;


import com.example.demo.services.AlumnoService;
import com.example.demo.services.ProfesorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesores")
@AllArgsConstructor
public class AlumnoController {
    private final AlumnoService service;
}
