package com.imber.sistema.controller;

import com.imber.sistema.entity.Evento;
import com.imber.sistema.dto.cliente.EventoCreateDTO;
import com.imber.sistema.dto.cliente.EventoListResponseDTO;
import com.imber.sistema.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService service;

    public EventoController(EventoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Evento> cadastrar(@Valid @RequestBody EventoCreateDTO dto) {
        Evento evento = new Evento();
        evento.setNome(dto.getNome());
        evento.setDescricao(dto.getDescricao());
        evento.setDataInicio(dto.getDataInicio());
        evento.setDataFim(dto.getDataFim());
        evento.setLocal(dto.getLocal());
        evento.setVagasTotais(dto.getVagasTotais());
        evento.setValorInscricao(dto.getValorInscricao());
        evento.setCategoria(dto.getCategoria());
        evento.setGratuito(dto.getGratuito());
        evento.setCargaHoraria(dto.getCargaHoraria());
        evento.setEmitirCertificado(dto.getEmitirCertificado());
        evento.setObservacoes(dto.getObservacoes());

        Evento novoEvento = service.cadastrar(evento);
        return new ResponseEntity<>(novoEvento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EventoListResponseDTO>> listar() {
        List<Evento> eventos = service.listarTodos();

        List<EventoListResponseDTO> dtos = eventos.stream()
            .map(e -> new EventoListResponseDTO(
                e.getId(),
                e.getNome(),
                e.getDataInicio(),
                e.getDataFim(),
                e.getLocal(),
                e.getCategoria(),
                e.getVagasTotais(),
                e.getVagasDisponiveis(),
                e.getValorInscricao(),
                e.getGratuito(),
                e.getStatus()
            ))
            .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
        Evento evento = service.buscarPorId(id);
        return ResponseEntity.ok(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody EventoCreateDTO dto) {

        Evento evento = new Evento();
        evento.setNome(dto.getNome());
        evento.setDescricao(dto.getDescricao());
        evento.setDataInicio(dto.getDataInicio());
        evento.setDataFim(dto.getDataFim());
        evento.setLocal(dto.getLocal());
        evento.setVagasTotais(dto.getVagasTotais());
        evento.setValorInscricao(dto.getValorInscricao());
        evento.setCategoria(dto.getCategoria());
        evento.setGratuito(dto.getGratuito());
        evento.setCargaHoraria(dto.getCargaHoraria());
        evento.setEmitirCertificado(dto.getEmitirCertificado());
        evento.setObservacoes(dto.getObservacoes());

        Evento eventoAtualizado = service.atualizar(id, evento);
        return ResponseEntity.ok(eventoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/futuros")
    public ResponseEntity<List<EventoListResponseDTO>> buscarEventosFuturos() {
        List<Evento> eventos = service.buscarEventosFuturos();

        List<EventoListResponseDTO> dtos = eventos.stream()
            .map(e -> new EventoListResponseDTO(
                e.getId(),
                e.getNome(),
                e.getDataInicio(),
                e.getDataFim(),
                e.getLocal(),
                e.getCategoria(),
                e.getVagasTotais(),
                e.getVagasDisponiveis(),
                e.getValorInscricao(),
                e.getGratuito(),
                e.getStatus()
            ))
            .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/com-vagas")
    public ResponseEntity<List<EventoListResponseDTO>> buscarEventosComVagas() {
        List<Evento> eventos = service.buscarEventosComVagas();

        List<EventoListResponseDTO> dtos = eventos.stream()
            .map(e -> new EventoListResponseDTO(
                e.getId(),
                e.getNome(),
                e.getDataInicio(),
                e.getDataFim(),
                e.getLocal(),
                e.getCategoria(),
                e.getVagasTotais(),
                e.getVagasDisponiveis(),
                e.getValorInscricao(),
                e.getGratuito(),
                e.getStatus()
            ))
            .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/gratuitos")
    public ResponseEntity<List<EventoListResponseDTO>> buscarEventosGratuitos() {
        List<Evento> eventos = service.buscarEventosGratuitos();

        List<EventoListResponseDTO> dtos = eventos.stream()
            .map(e -> new EventoListResponseDTO(
                e.getId(),
                e.getNome(),
                e.getDataInicio(),
                e.getDataFim(),
                e.getLocal(),
                e.getCategoria(),
                e.getVagasTotais(),
                e.getVagasDisponiveis(),
                e.getValorInscricao(),
                e.getGratuito(),
                e.getStatus()
            ))
            .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }
}