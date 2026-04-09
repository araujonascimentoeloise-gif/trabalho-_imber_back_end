package com.imber.sistema.dto.cliente;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrcamentoResponseDTO {

    private Long id;
    private ClienteListReponseDTO cliente;  // Dados resumidos do cliente
    private String descricao;
    private BigDecimal valor;
    private LocalDate dataOrcamento;
    private LocalDate dataValidade;
    private String status;
    private String observacoes;
    private LocalDateTime dataCadastro;

    // Construtor que recebe a entidade Orcamento
    public OrcamentoResponseDTO(com.imber.sistema.entity.Orcamento orcamento) {
        this.id = orcamento.getId();
        this.cliente = new ClienteListReponseDTO(
                orcamento.getCliente().getId(),
                orcamento.getCliente().getNomeCompleto(),
                orcamento.getCliente().getCpf(),
                orcamento.getCliente().getAtivo()
        );
        this.descricao = orcamento.getDescricao();
        this.valor = orcamento.getValor();
        this.dataOrcamento = orcamento.getDataOrcamento();
        this.dataValidade = orcamento.getDataValidade();
        this.status = orcamento.getStatus();
        this.observacoes = orcamento.getObservacoes();
        this.dataCadastro = orcamento.getDataCadastro();
    }

    // Getters (não precisa de setters, pois o DTO é apenas para leitura)
    public Long getId() { return id; }
    public ClienteListReponseDTO getCliente() { return cliente; }
    public String getDescricao() { return descricao; }
    public BigDecimal getValor() { return valor; }
    public LocalDate getDataOrcamento() { return dataOrcamento; }
    public LocalDate getDataValidade() { return dataValidade; }
    public String getStatus() { return status; }
    public String getObservacoes() { return observacoes; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }
}