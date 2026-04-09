package com.imber.sistema.dto.cliente;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class EventoCreateDTO {

    @NotBlank(message = "Nome do evento é obrigatório")
    @Size(min = 3, max = 200)
    private String nome;

    @Size(max = 500)
    private String descricao;

    @NotNull(message = "Data de início é obrigatória")
    @Future(message = "Data deve ser no futuro")
    private LocalDate dataInicio;

    @NotNull(message = "Data de fim é obrigatória")
    @Future(message = "Data deve ser no futuro")
    private LocalDate dataFim;

    @NotBlank(message = "Local é obrigatório")
    private String local;

    @Min(value = 1, message = "Vagas mínimas: 1")
    private Integer vagasTotais;

    @DecimalMin(value = "0.0")
    private BigDecimal valorInscricao;

    @NotBlank(message = "Categoria é obrigatória")
    private String categoria;

    private Boolean gratuito = false;

    @Min(value = 1)
    private Integer cargaHoraria;

    private Boolean emitirCertificado = true;

    private String observacoes;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
    public Integer getVagasTotais() { return vagasTotais; }
    public void setVagasTotais(Integer vagasTotais) { this.vagasTotais = vagasTotais; }
    public BigDecimal getValorInscricao() { return valorInscricao; }
    public void setValorInscricao(BigDecimal valorInscricao) { this.valorInscricao = valorInscricao; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public Boolean getGratuito() { return gratuito; }
    public void setGratuito(Boolean gratuito) { this.gratuito = gratuito; }
    public Integer getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(Integer cargaHoraria) { this.cargaHoraria = cargaHoraria; }
    public Boolean getEmitirCertificado() { return emitirCertificado; }
    public void setEmitirCertificado(Boolean emitirCertificado) { this.emitirCertificado = emitirCertificado; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}