package com.omar.clinicaodontologica.controller;

import com.omar.clinicaodontologica.entity.Turno;
import com.omar.clinicaodontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @GetMapping("/{id}")
    public ResponseEntity<Turno> getTurnoById(@PathVariable Long id) {
        return turnoService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Turno>> getAllTurnos() {
        return turnoService.getAll();
    }

    @PostMapping
    public ResponseEntity<Turno> saveTurno(@RequestBody Turno turno) {
        return turnoService.save(turno);
    }

    @PutMapping
    public ResponseEntity<Turno> updateTurnoById(@RequestBody Turno turno) {
        return turnoService.update(turno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTurno(@PathVariable Long id) {
        return turnoService.deleteById(id);
    }
}
