package com.imber.sistema.dto.cliente;

import jakarta.validation.constraints.NotNull;

public class InscricaoCreateDTO {

    @NotNull(message = "ID do evento é obrigatório")
    private Long eventoId;

    @NotNull(message = "ID do participante é obrigatório")
    private Long participanteId;

    private String observacoes;

    // Getters e Setters
    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Long getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Long participanteId) {
        this.participanteId = participanteId;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}