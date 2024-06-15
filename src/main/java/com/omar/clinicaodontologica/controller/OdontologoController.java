package com.omar.clinicaodontologica.controller;

import com.omar.clinicaodontologica.entity.Odontologo;
import com.omar.clinicaodontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> getOdontologoById(@PathVariable Long id) {
        return odontologoService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> getAllOdontologos() {
        return odontologoService.getAll();
    }

    @PostMapping
    public ResponseEntity<Odontologo> saveOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.save(odontologo);
    }

    @PutMapping
    public ResponseEntity<Odontologo> updateOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.update(odontologo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOdontologo(@PathVariable Long id) {
        return odontologoService.deleteById(id);
    }
}
