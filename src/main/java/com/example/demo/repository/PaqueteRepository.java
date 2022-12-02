package com.example.demo.repository;

import com.example.demo.model.Estado;
import com.example.demo.model.Paquete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaqueteRepository extends MongoRepository<Paquete, Long> {

    List<Paquete> findAllByEstado(Estado estado);

}
