package com.omar.clinicaodontologica.repository;

import com.omar.clinicaodontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Boolean existsPacienteByEmailIgnoreCase(String email);
}
