package com.imber.sistema.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inscricoes")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "participante_id", nullable = false)
    private Participante participante;

    @Column(length = 20)
    private String status;  // CONFIRMADA, CANCELADA, AGUARDANDO

    private Boolean presencaConfirmada = false;

    private LocalDateTime dataConfirmacaoPresenca;

    private Boolean certificadoEmitido = false;

    @Column(unique = true, length = 20)
    private String codigoCertificado;

    private LocalDateTime dataEmissaoCertificado;

    @Column(length = 500)
    private String observacoes;

    private LocalDateTime dataInscricao = LocalDateTime.now();

    private LocalDateTime dataCancelamento;

    // GETTERS E SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }
    public Participante getParticipante() { return participante; }
    public void setParticipante(Participante participante) { this.participante = participante; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Boolean getPresencaConfirmada() { return presencaConfirmada; }
    public void setPresencaConfirmada(Boolean presencaConfirmada) { this.presencaConfirmada = presencaConfirmada; }
    public LocalDateTime getDataConfirmacaoPresenca() { return dataConfirmacaoPresenca; }
    public void setDataConfirmacaoPresenca(LocalDateTime dataConfirmacaoPresenca) { this.dataConfirmacaoPresenca = dataConfirmacaoPresenca; }
    public Boolean getCertificadoEmitido() { return certificadoEmitido; }
    public void setCertificadoEmitido(Boolean certificadoEmitido) { this.certificadoEmitido = certificadoEmitido; }
    public String getCodigoCertificado() { return codigoCertificado; }
    public void setCodigoCertificado(String codigoCertificado) { this.codigoCertificado = codigoCertificado; }
    public LocalDateTime getDataEmissaoCertificado() { return dataEmissaoCertificado; }
    public void setDataEmissaoCertificado(LocalDateTime dataEmissaoCertificado) { this.dataEmissaoCertificado = dataEmissaoCertificado; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public LocalDateTime getDataInscricao() { return dataInscricao; }
    public void setDataInscricao(LocalDateTime dataInscricao) { this.dataInscricao = dataInscricao; }
    public LocalDateTime getDataCancelamento() { return dataCancelamento; }
    public void setDataCancelamento(LocalDateTime dataCancelamento) { this.dataCancelamento = dataCancelamento; }
}