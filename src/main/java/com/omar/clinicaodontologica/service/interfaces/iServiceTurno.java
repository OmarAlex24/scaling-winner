package com.omar.clinicaodontologica.service.interfaces;

import com.omar.clinicaodontologica.dto.TurnoDTO;
import com.omar.clinicaodontologica.entity.Turno;
import com.omar.clinicaodontologica.exception.ResourceNotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface iServiceTurno{
    ResponseEntity<Turno> save(TurnoDTO turno) throws ResourceNotFound;

    //Get
    ResponseEntity<List<Turno>> getAll();
    ResponseEntity<Turno> getById(Long id) throws ResourceNotFound;

    //Put
    ResponseEntity<Turno> update(Turno turno) throws ResourceNotFound;

    //Delete
    ResponseEntity<String> deleteById(Long id) throws ResourceNotFound;
}
