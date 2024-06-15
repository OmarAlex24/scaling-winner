package com.omar.clinicaodontologica.repository;

import com.omar.clinicaodontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
    Odontologo findByMatriculaIgnoreCase(String matricula);
    Boolean existsByMatricula(String matricula);
}
