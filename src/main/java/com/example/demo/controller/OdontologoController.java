package com.example.demo.controller;

import com.example.demo.model.Odontologo;
import com.example.demo.services.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/odontologos")
@AllArgsConstructor
public class OdontologoController {
    private final OdontologoService odontologoService;

    @GetMapping("/all")
    public List<Odontologo> listarOdontologos() {
        return odontologoService.listar();
    }

    @PostMapping("/nuevosOdontologos")
    public void agregarOdontologo(@RequestBody Odontologo odontologo) {
        if (odontologo != null) odontologoService.agregar(odontologo);
    }

    @PutMapping("/modificarOdontologos")
    public void modificarOdontologos(@RequestBody Odontologo odontologo) {
        odontologoService.modificar(odontologo);
    }

    @DeleteMapping("/eliminar")
    public void eliminarOdontologos(@RequestBody int matricula) {
        odontologoService.eliminar(matricula);
    }
}
