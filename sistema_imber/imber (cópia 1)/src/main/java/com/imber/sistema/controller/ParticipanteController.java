package com.imber.sistema.controller;

import com.imber.sistema.entity.Participante;
import com.imber.sistema.dto.cliente.ClienteCreateDTO;
import com.imber.sistema.dto.cliente.ClienteResponseDTO;
import com.imber.sistema.dto.cliente.ClienteListReponseDTO;
import com.imber.sistema.dto.cliente.ClienteUpdateDTO;
import com.imber.sistema.service.ParticipanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    private final ParticipanteService service;

    public ParticipanteController(ParticipanteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrar(@Valid @RequestBody ClienteCreateDTO dto) {
        Participante participante = new Participante();
        participante.setNomeCompleto(dto.getNomeCompleto());
        participante.setCpf(dto.getCpf());
        participante.setDataNascimento(dto.getDataNascimento());
        participante.setTelefone(dto.getTelefone());
        participante.setEmail(dto.getEmail());

        Participante novoParticipante = service.cadastrar(participante);

        ClienteResponseDTO responseDTO = new ClienteResponseDTO(
            novoParticipante.getId(),
            novoParticipante.getNomeCompleto(),
            novoParticipante.getCpf(),
            null, null, null, null, null,
            null, null, null, null, null, null, null,
            null, null, null, null, null, null
        );

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClienteListReponseDTO>> listar() {
        List<Participante> participantes = service.listarTodos();

        List<ClienteListReponseDTO> dtos = participantes.stream()
            .map(p -> new ClienteListReponseDTO(
                p.getId(),
                p.getNomeCompleto(),
                p.getCpf(),
                p.getAtivo()
            ))
            .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {
        Participante participante = service.buscarPorId(id);

        ClienteResponseDTO dto = new ClienteResponseDTO(
            participante.getId(),
            participante.getNomeCompleto(),
            participante.getCpf(),
            null, null, null, null, null,
            null, null, null, null, null, null, null,
            null, null, null, null, null, null
        );

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ClienteResponseDTO> buscarPorCpf(@PathVariable String cpf) {
        Participante participante = service.buscarPorCpf(cpf);

        ClienteResponseDTO dto = new ClienteResponseDTO(
            participante.getId(),
            participante.getNomeCompleto(),
            participante.getCpf(),
            null, null, null, null, null,
            null, null, null, null, null, null, null,
            null, null, null, null, null, null
        );

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ClienteUpdateDTO dto) {

        Participante participanteExistente = service.buscarPorId(id);

        if (dto.getNomeCompleto() != null) {
            participanteExistente.setNomeCompleto(dto.getNomeCompleto());
        }
        if (dto.getDataNascimento() != null) {
            participanteExistente.setDataNascimento(dto.getDataNascimento());
        }
        if (dto.getTelefone() != null) {
            participanteExistente.setTelefone(dto.getTelefone());
        }
        if (dto.getEmail() != null) {
            participanteExistente.setEmail(dto.getEmail());
        }
        if (dto.getObservacoes() != null) {
            participanteExistente.setObservacoes(dto.getObservacoes());
        }
        if (dto.getAtivo() != null) {
            participanteExistente.setAtivo(dto.getAtivo());
        }

        Participante participanteAtualizado = service.atualizar(id, participanteExistente);

        ClienteResponseDTO responseDTO = new ClienteResponseDTO(
            participanteAtualizado.getId(),
            participanteAtualizado.getNomeCompleto(),
            participanteAtualizado.getCpf(),
            null, null, null, null, null,
            null, null, null, null, null, null, null,
            null, null, null, null, null, null
        );

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}