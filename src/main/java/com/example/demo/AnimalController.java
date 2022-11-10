package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

    @GetMapping("/hola")
    public String hola(){
        return "<h1>hola!</h1>";
    }

}
