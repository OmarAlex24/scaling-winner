package com.omar.clinicaodontologica.service.interfaces;

import com.omar.clinicaodontologica.exception.ResourceNotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface iService<T> {
    //Post
    ResponseEntity<T> save(T t) throws ResourceNotFound;

    //Get
    ResponseEntity<List<T>> getAll();
    ResponseEntity<T> getById(Long id) throws ResourceNotFound;

    //Put
    ResponseEntity<T> update(T t) throws ResourceNotFound;

    //Delete
    ResponseEntity<String> deleteById(Long id) throws ResourceNotFound;
}
