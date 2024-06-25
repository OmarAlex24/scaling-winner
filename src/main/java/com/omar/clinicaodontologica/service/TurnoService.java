package com.omar.clinicaodontologica.service;

import com.omar.clinicaodontologica.dto.TurnoDTO;
import com.omar.clinicaodontologica.entity.Domicilio;
import com.omar.clinicaodontologica.entity.Odontologo;
import com.omar.clinicaodontologica.entity.Paciente;
import com.omar.clinicaodontologica.entity.Turno;
import com.omar.clinicaodontologica.exception.ResourceNotFound;
import com.omar.clinicaodontologica.repository.DomicilioRepository;
import com.omar.clinicaodontologica.repository.OdontologoRepository;
import com.omar.clinicaodontologica.repository.PacienteRepository;
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

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    OdontologoRepository odontologoRepository;

    @Override
    public ResponseEntity<Turno> save(TurnoDTO turno) throws ResourceNotFound{
        Odontologo odontologoBuscado = odontologoRepository.findById(turno.getOdontologoId()).orElseThrow(() -> new ResourceNotFound("Odontologo no encontrado"));
        Paciente pacienteBuscado = pacienteRepository.findById(turno.getPacienteId()).orElseThrow(() -> new ResourceNotFound("Paciente no encontrado"));

        return ResponseEntity.ok(turnoRepository.save(new Turno(pacienteBuscado, odontologoBuscado, turno.getFecha())));
    }

    @Override
    public ResponseEntity<List<Turno>> getAll() {
        return ResponseEntity.ok(turnoRepository.findAll());
    }

    @Override
    public ResponseEntity<Turno> getById(Long id) throws ResourceNotFound{
        if(turnoRepository.findById(id).isEmpty()){
            throw new ResourceNotFound("Turno no encontrado");
        }
        return ResponseEntity.ok(turnoRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<Turno> update(Turno turno) throws ResourceNotFound {
        if(turnoRepository.findById(turno.getId()).isEmpty()){
            throw new ResourceNotFound("Turno no encontrado");
        }
        return ResponseEntity.ok(turnoRepository.save(turno));
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) throws ResourceNotFound {
        if(turnoRepository.findById(id).isEmpty()){
            throw new ResourceNotFound("Turno no encontrado");
        }
        turnoRepository.deleteById(id);
        return ResponseEntity.ok("Turno eliminado correctamente");
    }
}
