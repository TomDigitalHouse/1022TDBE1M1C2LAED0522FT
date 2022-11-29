package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Match(long id, State state, Result result, Team local, Team away) {
}
