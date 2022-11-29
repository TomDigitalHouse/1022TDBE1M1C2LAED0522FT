package com.example.demo.controllers;

import com.example.demo.model.Match;
import com.example.demo.services.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/match")
public class MatchController {
    private final MatchService service;

    @PostMapping("/save")
    public ResponseEntity<Match> saveMatch(@RequestBody Match match){
        return ResponseEntity.ok(service.save(match));
    }
}
