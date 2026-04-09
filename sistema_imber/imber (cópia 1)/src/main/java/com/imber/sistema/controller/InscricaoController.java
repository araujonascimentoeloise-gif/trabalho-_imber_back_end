package com.imber.sistema.controller;

import com.imber.sistema.entity.Inscricao;
import com.imber.sistema.dto.cliente.InscricaoCreateDTO;
import com.imber.sistema.dto.cliente.InscricaoResponseDTO;
import com.imber.sistema.service.InscricaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    private final InscricaoService service;

    public InscricaoController(InscricaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InscricaoResponseDTO> realizarInscricao(@Valid @RequestBody InscricaoCreateDTO dto) {
        Inscricao inscricao = service.realizarInscricao(
            dto.getEventoId(),
            dto.getParticipanteId(),
            dto.getObservacoes()
        );
        return new ResponseEntity<>(new InscricaoResponseDTO(inscricao), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InscricaoResponseDTO>> listarTodas() {
        List<Inscricao> inscricoes = service.listarTodas();
        List<InscricaoResponseDTO> dtos = inscricoes.stream()
            .map(InscricaoResponseDTO::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscricaoResponseDTO> buscarPorId(@PathVariable Long id) {
        Inscricao inscricao = service.buscarPorId(id);
        return ResponseEntity.ok(new InscricaoResponseDTO(inscricao));
    }

    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<InscricaoResponseDTO>> listarPorEvento(@PathVariable Long eventoId) {
        List<Inscricao> inscricoes = service.listarPorEvento(eventoId);
        List<InscricaoResponseDTO> dtos = inscricoes.stream()
            .map(InscricaoResponseDTO::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/participante/{participanteId}")
    public ResponseEntity<List<InscricaoResponseDTO>> listarPorParticipante(@PathVariable Long participanteId) {
        List<Inscricao> inscricoes = service.listarPorParticipante(participanteId);
        List<InscricaoResponseDTO> dtos = inscricoes.stream()
            .map(InscricaoResponseDTO::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PatchMapping("/{id}/confirmar-presenca")
    public ResponseEntity<InscricaoResponseDTO> confirmarPresenca(@PathVariable Long id) {
        Inscricao inscricao = service.confirmarPresenca(id);
        return ResponseEntity.ok(new InscricaoResponseDTO(inscricao));
    }

    @PatchMapping("/{id}/emitir-certificado")
    public ResponseEntity<InscricaoResponseDTO> emitirCertificado(@PathVariable Long id) {
        Inscricao inscricao = service.emitirCertificado(id);
        return ResponseEntity.ok(new InscricaoResponseDTO(inscricao));
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarInscricao(@PathVariable Long id) {
        service.cancelarInscricao(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/evento/{eventoId}/contar")
    public ResponseEntity<Long> contarPorEvento(@PathVariable Long eventoId) {
        Long total = service.contarPorEvento(eventoId);
        return ResponseEntity.ok(total);
    }
}