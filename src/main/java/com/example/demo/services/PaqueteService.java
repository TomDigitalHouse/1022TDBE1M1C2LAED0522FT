package com.example.demo.services;

import com.example.demo.model.Estado;
import com.example.demo.model.Paquete;
import com.example.demo.repository.PaqueteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class PaqueteService {

    private final PaqueteRepository repository;

    public Paquete agregar(Paquete paquete) throws PaqueteException, BadRequestException {
        if (Objects.isNull(paquete.destino())) throw new BadRequestException();
        if (repository.exists(Example.of(paquete))) throw new PaqueteException();
        return repository.save(paquete);
    }

    public List<Paquete> listar() {
        return repository.findAll();
    }

    public List<Paquete> listarPaquetesEnCamino() {
        return repository.findAllByEstado(Estado.EN_CAMINO);
    }

}
