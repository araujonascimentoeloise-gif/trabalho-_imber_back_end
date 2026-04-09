package com.imber.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imber.sistema.entity.Orcamento;

import java.util.List;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
    // Método para buscar orçamentos por cliente
    List<Orcamento> findByClienteId(Long clienteId);
}