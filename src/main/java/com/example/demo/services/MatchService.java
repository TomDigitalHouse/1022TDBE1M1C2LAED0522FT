package com.example.demo.services;

import com.example.demo.model.Match;
import com.example.demo.repository.MatchRepository;
import com.example.demo.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MatchService {
    private final MatchRepository matchRepository;

    public Match save(Match match){
        return matchRepository.save(match);
    }
}
