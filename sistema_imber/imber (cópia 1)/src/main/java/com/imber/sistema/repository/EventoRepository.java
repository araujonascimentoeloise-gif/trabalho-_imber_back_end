package com.imber.sistema.repository;

import com.imber.sistema.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByNomeContainingIgnoreCase(String nome);
    List<Evento> findByCategoria(String categoria);
    List<Evento> findByStatus(String status);
    List<Evento> findByDataInicioGreaterThanEqual(LocalDate data);
    List<Evento> findByVagasDisponiveisGreaterThan(Integer vagas);
    List<Evento> findByGratuitoTrue();
    List<Evento> findByAtivoTrue();
    boolean existsByNomeAndDataInicio(String nome, LocalDate dataInicio);
}