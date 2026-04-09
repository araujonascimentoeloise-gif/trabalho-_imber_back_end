package com.imber.sistema.dto.cliente;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrcamentoCreateDTO {

    private Long clienteId;  // Id do cliente ao qual o orçamento pertence
    private String descricao;
    private BigDecimal valor;
    private LocalDate dataOrcamento;
    private LocalDate dataValidade;
    private String status;
    private String observacoes;

    // Getters e Setters
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public LocalDate getDataOrcamento() { return dataOrcamento; }
    public void setDataOrcamento(LocalDate dataOrcamento) { this.dataOrcamento = dataOrcamento; }

    public LocalDate getDataValidade() { return dataValidade; }
    public void setDataValidade(LocalDate dataValidade) { this.dataValidade = dataValidade; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}