package com.example.demo.controller;

import com.example.demo.model.Paciente;
import com.example.demo.repository.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class PacienteController {

    private final PacienteService service;

    @GetMapping("/paciente")
    public String getPaciente(String email, Model model) throws Exception {

        if (service.getPaciente(email).isEmpty()) throw new Exception();

        model.addAttribute("paciente", service.getPaciente(email).get());

        return "index";
    }
    @GetMapping("/pacientes")
    public String getAll(Model model){
        model.addAttribute("pacientes", service.getAll());
        return "index";
    }

    @PostMapping("/paciente")
    public String addPaciente(@RequestBody Paciente paciente, Model model){
        service.add(paciente);
        model.addAttribute("paciente", paciente);
        return "index";
    }

}
