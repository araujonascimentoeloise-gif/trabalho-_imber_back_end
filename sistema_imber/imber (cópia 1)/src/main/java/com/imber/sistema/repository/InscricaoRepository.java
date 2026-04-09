package com.imber.sistema.repository;

import com.imber.sistema.entity.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    List<Inscricao> findByEventoId(Long eventoId);
    List<Inscricao> findByParticipanteId(Long participanteId);
    Optional<Inscricao> findByEventoIdAndParticipanteId(Long eventoId, Long participanteId);
    List<Inscricao> findByStatus(String status);
    List<Inscricao> findByPresencaConfirmadaTrue();
    List<Inscricao> findByCertificadoEmitidoTrue();
    Long countByEventoId(Long eventoId);
    boolean existsByEventoIdAndParticipanteId(Long eventoId, Long participanteId);
}