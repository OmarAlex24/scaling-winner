package com.omar.clinicaodontologica.service;

import com.omar.clinicaodontologica.entity.Paciente;
import com.omar.clinicaodontologica.repository.PacienteRepository;
import com.omar.clinicaodontologica.service.interfaces.iServicePaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService implements iServicePaciente {
    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public ResponseEntity<Paciente> save(Paciente paciente) {
        if(pacienteRepository.existsById(paciente.getId())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(pacienteRepository.save(paciente));
    }

    @Override
    public ResponseEntity<List<Paciente>> getAll() {
        return ResponseEntity.ok(pacienteRepository.findAll());
    }

    @Override
    public ResponseEntity<Paciente> getById(Long id) {
        if(pacienteRepository.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pacienteRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<Paciente> update(Paciente paciente) {
        if(pacienteRepository.findById(paciente.getId()).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pacienteRepository.save(paciente));
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        if(pacienteRepository.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        pacienteRepository.deleteById(id);
        return ResponseEntity.ok("Paciente eliminado correctamente");
    }
}
