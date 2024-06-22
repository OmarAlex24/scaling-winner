package com.omar.clinicaodontologica.service;

import com.omar.clinicaodontologica.entity.Paciente;
import com.omar.clinicaodontologica.exception.ResourceNotFound;
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
    public ResponseEntity<Paciente> save(Paciente paciente) throws ResourceNotFound {
        if(pacienteRepository.existsPacienteByEmailIgnoreCase(paciente.getEmail())){
            throw new ResourceNotFound("El email ya se encuentra registrado");
        }
        return ResponseEntity.ok(pacienteRepository.save(paciente));
    }

    @Override
    public ResponseEntity<List<Paciente>> getAll() {
        return ResponseEntity.ok(pacienteRepository.findAll());
    }

    @Override
    public ResponseEntity<Paciente> getById(Long id) throws ResourceNotFound {
        if(pacienteRepository.findById(id).isEmpty()){
            throw new ResourceNotFound("Paciente no encontrado");
        }
        return ResponseEntity.ok(pacienteRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<Paciente> update(Paciente paciente) throws ResourceNotFound {
        if(pacienteRepository.findById(paciente.getId()).isEmpty()){
            throw new ResourceNotFound("Paciente no encontrado");
        }
        return ResponseEntity.ok(pacienteRepository.save(paciente));
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) throws ResourceNotFound {
        if(pacienteRepository.findById(id).isEmpty()){
            throw new ResourceNotFound("Paciente no encontrado");
        }
        pacienteRepository.deleteById(id);
        return ResponseEntity.ok("Paciente eliminado correctamente");
    }
}
