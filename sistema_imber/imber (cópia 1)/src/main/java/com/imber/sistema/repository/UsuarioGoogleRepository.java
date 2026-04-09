package com.imber.sistema.repository;

import com.imber.sistema.entity.UsuarioGoogle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioGoogleRepository extends JpaRepository<UsuarioGoogle, Long> {
    Optional<UsuarioGoogle> findByEmail(String email);
    Optional<UsuarioGoogle> findByGoogleId(String googleId);
}