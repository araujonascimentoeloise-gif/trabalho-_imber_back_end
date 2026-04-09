package com.imber.sistema.repository;

import com.imber.sistema.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    Optional<Participante> findByCpf(String cpf);
    Optional<Participante> findByEmail(String email);
    List<Participante> findByNomeCompletoContainingIgnoreCase(String nome);
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}