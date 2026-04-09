package com.imber.sistema.dto.cliente;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class OrcamentoUpdateDTO {

    @NotBlank
    @Size(min = 3, max = 200)
    private String descricao;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal valor;

    private LocalDate dataOrcamento;
    private LocalDate dataValidade;

    @Pattern(regexp = "APROVADO|PENDENTE|CANCELADO", message = "Status deve ser APROVADO, PENDENTE ou CANCELADO")
    private String status;

    private String observacoes;

    // Getters e Setters
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