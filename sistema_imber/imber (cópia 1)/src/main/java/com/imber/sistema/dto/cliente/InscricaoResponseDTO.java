package com.imber.sistema.dto.cliente;

import com.imber.sistema.entity.Inscricao;
import java.time.LocalDateTime;

public class InscricaoResponseDTO {

    private Long id;
    private Long eventoId;
    private String eventoNome;
    private Long participanteId;
    private String participanteNome;
    private String status;
    private Boolean presencaConfirmada;
    private LocalDateTime dataConfirmacaoPresenca;
    private Boolean certificadoEmitido;
    private String codigoCertificado;
    private LocalDateTime dataInscricao;

    public InscricaoResponseDTO(Inscricao inscricao) {
        this.id = inscricao.getId();
        
        if (inscricao.getEvento() != null) {
            this.eventoId = inscricao.getEvento().getId();
            this.eventoNome = inscricao.getEvento().getNome();
        }
        
        if (inscricao.getParticipante() != null) {
            this.participanteId = inscricao.getParticipante().getId();
            this.participanteNome = inscricao.getParticipante().getNomeCompleto();
        }
        
        this.status = inscricao.getStatus();
        this.presencaConfirmada = inscricao.getPresencaConfirmada();
        this.dataConfirmacaoPresenca = inscricao.getDataConfirmacaoPresenca();
        this.certificadoEmitido = inscricao.getCertificadoEmitido();
        this.codigoCertificado = inscricao.getCodigoCertificado();
        this.dataInscricao = inscricao.getDataInscricao();
    }

    // Getters (sem setters - imutável)
    public Long getId() { return id; }
    public Long getEventoId() { return eventoId; }
    public String getEventoNome() { return eventoNome; }
    public Long getParticipanteId() { return participanteId; }
    public String getParticipanteNome() { return participanteNome; }
    public String getStatus() { return status; }
    public Boolean getPresencaConfirmada() { return presencaConfirmada; }
    public LocalDateTime getDataConfirmacaoPresenca() { return dataConfirmacaoPresenca; }
    public Boolean getCertificadoEmitido() { return certificadoEmitido; }
    public String getCodigoCertificado() { return codigoCertificado; }
    public LocalDateTime getDataInscricao() { return dataInscricao; }
}