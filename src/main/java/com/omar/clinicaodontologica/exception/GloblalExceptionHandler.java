package com.omar.clinicaodontologica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloblalExceptionHandler {
    @ExceptionHandler({ResourceNotFound.class})
    public ResponseEntity<String> tratamientoResourceNotFound(ResourceNotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("mensaje: "+e.getMessage());
    }
}
