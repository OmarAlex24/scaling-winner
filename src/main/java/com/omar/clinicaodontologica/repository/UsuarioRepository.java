package com.omar.clinicaodontologica.repository;

import com.omar.clinicaodontologica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
