package com.example.demo.config;

import com.example.demo.model.Rol;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Hardcode implements ApplicationRunner {

    private final UserRepository repository;

    @Override
    public void run(ApplicationArguments args) {
        var user = new Usuarios(null, "Ariel", "ariel@gmail.com", new BCryptPasswordEncoder().encode("7777"), Rol.USER);
        repository.save(user);
    }
}
