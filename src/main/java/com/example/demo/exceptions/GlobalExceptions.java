package com.example.demo.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptions {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptions.class);

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> error(ResourceNotFoundException exception){
        logger.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler({PacienteNotFoundException.class})
    public ResponseEntity<String> error(PacienteNotFoundException exception){
        logger.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED).body(exception.getMessage());
    }

}
