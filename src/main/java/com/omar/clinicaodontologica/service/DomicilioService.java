package com.omar.clinicaodontologica.service;

import com.omar.clinicaodontologica.entity.Domicilio;
import com.omar.clinicaodontologica.repository.DomicilioRepository;
import com.omar.clinicaodontologica.service.interfaces.iServiceDomicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DomicilioService implements iServiceDomicilio {
    @Autowired
    DomicilioRepository domicilioRepository;


    @Override
    public ResponseEntity<Domicilio> save(Domicilio domicilio) {
        if(domicilioRepository.existsById(domicilio.getId())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(domicilioRepository.save(domicilio));
    }

    @Override
    public ResponseEntity<List<Domicilio>> getAll() {
        return ResponseEntity.ok(domicilioRepository.findAll());
    }

    @Override
    public ResponseEntity<Domicilio> getById(Long id) {
        if(domicilioRepository.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(domicilioRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<Domicilio> update(Domicilio domicilio) {
        if(domicilioRepository.findById(domicilio.getId()).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(domicilioRepository.save(domicilio));
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        if(domicilioRepository.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        domicilioRepository.deleteById(id);
        return ResponseEntity.ok("Domicilio eliminado correctamente");
    }
}
