package com.omar.clinicaodontologica.service;

import com.omar.clinicaodontologica.entity.Odontologo;
import com.omar.clinicaodontologica.exception.ResourceNotFound;
import com.omar.clinicaodontologica.repository.OdontologoRepository;
import com.omar.clinicaodontologica.service.interfaces.iServiceOdontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OdontologoService implements iServiceOdontologo {
    @Autowired
    OdontologoRepository odontologoRepository;

    @Override
    public ResponseEntity<Odontologo> save(Odontologo odontologo) {
        if(odontologoRepository.existsById(odontologo.getId())
                || odontologoRepository.existsByMatricula(odontologo.getMatricula())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(odontologoRepository.save(odontologo));
    }

    @Override
    public ResponseEntity<List<Odontologo>> getAll() {
        return ResponseEntity.ok(odontologoRepository.findAll());
    }

    @Override
    public ResponseEntity<Odontologo> getById(Long id) throws ResourceNotFound{
        if(odontologoRepository.findById(id).isEmpty()){
            throw new ResourceNotFound("Odontologo no encontrado");
        }
        return ResponseEntity.ok(odontologoRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<Odontologo> update(Odontologo odontologo) throws ResourceNotFound {
        if(odontologoRepository.findById(odontologo.getId()).isEmpty()){
            throw new ResourceNotFound("Odontologo no encontrado");
        }
        return ResponseEntity.ok(odontologoRepository.save(odontologo));
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) throws ResourceNotFound {
        if(odontologoRepository.findById(id).isEmpty()){
            throw new ResourceNotFound("Odontologo no encontrado");
        }
        odontologoRepository.deleteById(id);
        return ResponseEntity.ok("Odontologo eliminado correctamente");
    }
}
