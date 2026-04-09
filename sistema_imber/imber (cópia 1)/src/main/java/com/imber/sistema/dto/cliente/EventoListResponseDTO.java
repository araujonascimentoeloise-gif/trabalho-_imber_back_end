package com.imber.sistema.dto.cliente;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EventoListResponseDTO {

    private Long id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String local;
    private String categoria;
    private Integer vagasTotais;
    private Integer vagasDisponiveis;
    private BigDecimal valorInscricao;
    private Boolean gratuito;
    private String status;

    public EventoListResponseDTO(Long id, String nome, LocalDate dataInicio, LocalDate dataFim,
            String local, String categoria, Integer vagasTotais, Integer vagasDisponiveis,
            BigDecimal valorInscricao, Boolean gratuito, String status) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.local = local;
        this.categoria = categoria;
        this.vagasTotais = vagasTotais;
        this.vagasDisponiveis = vagasDisponiveis;
        this.valorInscricao = valorInscricao;
        this.gratuito = gratuito;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public Integer getVagasTotais() { return vagasTotais; }
    public void setVagasTotais(Integer vagasTotais) { this.vagasTotais = vagasTotais; }
    public Integer getVagasDisponiveis() { return vagasDisponiveis; }
    public void setVagasDisponiveis(Integer vagasDisponiveis) { this.vagasDisponiveis = vagasDisponiveis; }
    public BigDecimal getValorInscricao() { return valorInscricao; }
    public void setValorInscricao(BigDecimal valorInscricao) { this.valorInscricao = valorInscricao; }
    public Boolean getGratuito() { return gratuito; }
    public void setGratuito(Boolean gratuito) { this.gratuito = gratuito; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}