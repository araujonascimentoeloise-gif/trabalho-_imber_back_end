package com.imber.sistema.dto.cliente;

import com.imber.sistema.entity.Orcamento;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO para listagem resumida de orçamentos.
 * Contém apenas os campos principais e informações básicas do cliente.
 */
public class OrcamentoListResponseDTO {

    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate dataOrcamento;
    private String status;
    private ClienteListReponseDTO cliente; // Dados resumidos do cliente

    /**
     * Construtor que converte uma entidade Orcamento para este DTO.
     * @param orcamento Entidade Orcamento (já carregada com o cliente)
     */
    public OrcamentoListResponseDTO(Orcamento orcamento) {
        this.id = orcamento.getId();
        this.descricao = orcamento.getDescricao();
        this.valor = orcamento.getValor();
        this.dataOrcamento = orcamento.getDataOrcamento();
        this.status = orcamento.getStatus();

        // Cria o DTO do cliente com os dados básicos (id, nome, cpf, ativo)
        if (orcamento.getCliente() != null) {
            this.cliente = new ClienteListReponseDTO(
                orcamento.getCliente().getId(),
                orcamento.getCliente().getNomeCompleto(),
                orcamento.getCliente().getCpf(),
                orcamento.getCliente().getAtivo()
            );
        }
    }

    // Getters (apenas leitura, sem setters)
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataOrcamento() {
        return dataOrcamento;
    }

    public String getStatus() {
        return status;
    }

    public ClienteListReponseDTO getCliente() {
        return cliente;
    }
}