package com.omar.clinicaodontologica.controller;

import com.omar.clinicaodontologica.entity.Paciente;
import com.omar.clinicaodontologica.exception.ResourceNotFound;
import com.omar.clinicaodontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) throws ResourceNotFound {
        return pacienteService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        return pacienteService.getAll();
    }

    @PostMapping
    public ResponseEntity<Paciente> savePaciente(@RequestBody Paciente paciente) throws ResourceNotFound{
        return pacienteService.save(paciente);
    }

    @PutMapping
    public ResponseEntity<Paciente> updatePacienteById(@RequestBody Paciente paciente) throws ResourceNotFound {
        return pacienteService.update(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Long id) throws ResourceNotFound {
        return pacienteService.deleteById(id);
    }
}
