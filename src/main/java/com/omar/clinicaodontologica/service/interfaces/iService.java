package com.omar.clinicaodontologica.service.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface iService<T> {
    //Post
    ResponseEntity<T> save(T t);

    //Get
    ResponseEntity<List<T>> getAll();
    ResponseEntity<T> getById(Long id);

    //Put
    ResponseEntity<T> update(T t);

    //Delete
    ResponseEntity<String> deleteById(Long id);
}
