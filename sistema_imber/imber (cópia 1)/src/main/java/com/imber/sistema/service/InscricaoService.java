package com.imber.sistema.service;

import com.imber.sistema.entity.Inscricao;
import com.imber.sistema.entity.Evento;
import com.imber.sistema.entity.Participante;
import com.imber.sistema.repository.InscricaoRepository;
import com.imber.sistema.repository.EventoRepository;
import com.imber.sistema.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final EventoRepository eventoRepository;
    private final ParticipanteRepository participanteRepository;

    public InscricaoService(InscricaoRepository inscricaoRepository,
                           EventoRepository eventoRepository,
                           ParticipanteRepository participanteRepository) {
        this.inscricaoRepository = inscricaoRepository;
        this.eventoRepository = eventoRepository;
        this.participanteRepository = participanteRepository;
    }

    @Transactional
    public Inscricao realizarInscricao(Long eventoId, Long participanteId, String observacoes) {
        Evento evento = eventoRepository.findById(eventoId)
                .filter(Evento::getAtivo)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        Participante participante = participanteRepository.findById(participanteId)
                .orElseThrow(() -> new RuntimeException("Participante não encontrado"));

        if (inscricaoRepository.existsByEventoIdAndParticipanteId(eventoId, participanteId)) {
            throw new RuntimeException("Participante já está inscrito!");
        }

        if (evento.getVagasDisponiveis() <= 0) {
            throw new RuntimeException("Evento sem vagas!");
        }

        Inscricao inscricao = new Inscricao();
        inscricao.setEvento(evento);
        inscricao.setParticipante(participante);
        inscricao.setStatus("CONFIRMADA");
        inscricao.setObservacoes(observacoes);
        inscricao.setDataInscricao(LocalDateTime.now());

        evento.setVagasDisponiveis(evento.getVagasDisponiveis() - 1);
        eventoRepository.save(evento);

        return inscricaoRepository.save(inscricao);
    }

    public List<Inscricao> listarTodas() {
        return inscricaoRepository.findAll();
    }

    public Inscricao buscarPorId(Long id) {
        return inscricaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscrição não encontrada"));
    }

    public List<Inscricao> listarPorEvento(Long eventoId) {
        return inscricaoRepository.findByEventoId(eventoId);
    }

    public List<Inscricao> listarPorParticipante(Long participanteId) {
        return inscricaoRepository.findByParticipanteId(participanteId);
    }

    @Transactional
    public Inscricao confirmarPresenca(Long id) {
        Inscricao inscricao = buscarPorId(id);
        inscricao.setPresencaConfirmada(true);
        inscricao.setDataConfirmacaoPresenca(LocalDateTime.now());
        return inscricaoRepository.save(inscricao);
    }

    @Transactional
    public Inscricao emitirCertificado(Long id) {
        Inscricao inscricao = buscarPorId(id);

        if (!inscricao.getPresencaConfirmada()) {
            throw new RuntimeException("Presença não confirmada!");
        }

        String codigo = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        inscricao.setCertificadoEmitido(true);
        inscricao.setCodigoCertificado(codigo);
        inscricao.setDataEmissaoCertificado(LocalDateTime.now());

        return inscricaoRepository.save(inscricao);
    }

    @Transactional
    public void cancelarInscricao(Long id) {
        Inscricao inscricao = buscarPorId(id);
        
        Evento evento = inscricao.getEvento();
        evento.setVagasDisponiveis(evento.getVagasDisponiveis() + 1);
        eventoRepository.save(evento);

        inscricao.setStatus("CANCELADA");
        inscricao.setDataCancelamento(LocalDateTime.now());
        inscricaoRepository.save(inscricao);
    }

    @Transactional
    public void deletar(Long id) {
        if (!inscricaoRepository.existsById(id)) {
            throw new RuntimeException("Inscrição não encontrada");
        }
        inscricaoRepository.deleteById(id);
    }

    public Long contarPorEvento(Long eventoId) {
        return inscricaoRepository.countByEventoId(eventoId);
    }
}