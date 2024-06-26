package com.omar.clinicaodontologica.controller;

import com.omar.clinicaodontologica.entity.Domicilio;
import com.omar.clinicaodontologica.exception.ResourceNotFound;
import com.omar.clinicaodontologica.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
@CrossOrigin(origins = "http://localhost:5173")
public class DomicilioController {
  @Autowired
  private DomicilioService domicilioService;

  @GetMapping("/{id}")
  public ResponseEntity<Domicilio> getDomicilioById(@PathVariable Long id) throws ResourceNotFound {
    return domicilioService.getById(id);
  }

  @GetMapping
  public ResponseEntity<List<Domicilio>> getAllDomicilios() {
    return domicilioService.getAll();
  }

  @PostMapping
  public ResponseEntity<Domicilio> saveDomicilio(@RequestBody Domicilio domicilio) {
    return domicilioService.save(domicilio);
  }

  @PutMapping
  public ResponseEntity<Domicilio> updateDomicilio(@RequestBody Domicilio domicilio) throws ResourceNotFound {
    return domicilioService.update(domicilio);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteDomicilio(@PathVariable Long id) throws ResourceNotFound {
    return domicilioService.deleteById(id);
  }
}
