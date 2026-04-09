package com.imber.sistema.service;

import com.imber.sistema.entity.Evento;
import com.imber.sistema.repository.EventoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventoService {

    private final EventoRepository repository;

    public EventoService(EventoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Evento cadastrar(Evento evento) {
        if (repository.existsByNomeAndDataInicio(evento.getNome(), evento.getDataInicio())) {
            throw new RuntimeException("Evento com este nome já existe nesta data!");
        }
        if (evento.getDataFim().isBefore(evento.getDataInicio())) {
            throw new RuntimeException("Data fim não pode ser antes da data início!");
        }
        if (evento.getDataInicio().isBefore(LocalDate.now())) {
            throw new RuntimeException("Data início deve ser no futuro!");
        }

        evento.setVagasDisponiveis(evento.getVagasTotais());
        evento.setStatus("AGENDADO");
        evento.setAtivo(true);
        evento.setDataCadastro(LocalDateTime.now());

        return repository.save(evento);
    }

    public List<Evento> listarTodos() {
        return repository.findByAtivoTrue();
    }

    public Evento buscarPorId(Long id) {
        return repository.findById(id)
                .filter(Evento::getAtivo)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
    }

    @Transactional
    public Evento atualizar(Long id, Evento eventoAtualizado) {
        Evento eventoExistente = buscarPorId(id);

        eventoExistente.setNome(eventoAtualizado.getNome());
        eventoExistente.setDescricao(eventoAtualizado.getDescricao());
        eventoExistente.setDataInicio(eventoAtualizado.getDataInicio());
        eventoExistente.setDataFim(eventoAtualizado.getDataFim());
        eventoExistente.setLocal(eventoAtualizado.getLocal());
        eventoExistente.setValorInscricao(eventoAtualizado.getValorInscricao());
        eventoExistente.setCategoria(eventoAtualizado.getCategoria());
        eventoExistente.setGratuito(eventoAtualizado.getGratuito());
        eventoExistente.setEmitirCertificado(eventoAtualizado.getEmitirCertificado());
        eventoExistente.setCargaHoraria(eventoAtualizado.getCargaHoraria());
        eventoExistente.setObservacoes(eventoAtualizado.getObservacoes());
        eventoExistente.setDataAtualizacao(LocalDateTime.now());

        return repository.save(eventoExistente);
    }

    @Transactional
    public void deletar(Long id) {
        Evento evento = buscarPorId(id);
        if (!evento.getInscricoes().isEmpty()) {
            throw new RuntimeException("Não é possível deletar evento com inscrições!");
        }
        evento.setAtivo(false);
        repository.save(evento);
    }

    public List<Evento> buscarEventosFuturos() {
        return repository.findByDataInicioGreaterThanEqual(LocalDate.now());
    }

    public List<Evento> buscarEventosComVagas() {
        return repository.findByVagasDisponiveisGreaterThan(0);
    }

    public List<Evento> buscarEventosGratuitos() {
        return repository.findByGratuitoTrue();
    }
}