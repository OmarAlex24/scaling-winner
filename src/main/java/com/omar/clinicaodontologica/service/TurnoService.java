package com.omar.clinicaodontologica.service;

import com.omar.clinicaodontologica.entity.Turno;
import com.omar.clinicaodontologica.repository.TurnoRepository;
import com.omar.clinicaodontologica.service.interfaces.iServiceTurno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TurnoService implements iServiceTurno {
    @Autowired
    TurnoRepository turnoRepository;

    @Override
    public ResponseEntity<Turno> save(Turno turno) {
        if(turnoRepository.existsById(turno.getId())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(turnoRepository.save(turno));
    }

    @Override
    public ResponseEntity<List<Turno>> getAll() {
        return ResponseEntity.ok(turnoRepository.findAll());
    }

    @Override
    public ResponseEntity<Turno> getById(Long id) {
        if(turnoRepository.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turnoRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<Turno> update(Turno turno) {
        if(turnoRepository.findById(turno.getId()).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(turnoRepository.save(turno));
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        if(turnoRepository.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        turnoRepository.deleteById(id);
        return ResponseEntity.ok("Turno eliminado correctamente");
    }
}
