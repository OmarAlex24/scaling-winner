package com.omar.clinicaodontologica.repository;

import com.omar.clinicaodontologica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUserName(String username);
    Optional<Usuario> findByEmail(String email);
}
