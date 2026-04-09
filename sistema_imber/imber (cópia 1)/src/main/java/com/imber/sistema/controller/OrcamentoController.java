package com.imber.sistema.controller;

import com.imber.sistema.entity.Orcamento;
import com.imber.sistema.dto.cliente.OrcamentoCreateDTO;
import com.imber.sistema.dto.cliente.OrcamentoResponseDTO;
import com.imber.sistema.dto.cliente.OrcamentoListResponseDTO;
import com.imber.sistema.dto.cliente.OrcamentoUpdateDTO;
import com.imber.sistema.service.OrcamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController {

    private final OrcamentoService service;

    public OrcamentoController(OrcamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrcamentoResponseDTO> cadastrar(@Valid @RequestBody OrcamentoCreateDTO dto) {
        Orcamento orcamento = new Orcamento();
        orcamento.setDescricao(dto.getDescricao());
        orcamento.setValor(dto.getValor());
        orcamento.setDataOrcamento(dto.getDataOrcamento());
        orcamento.setDataValidade(dto.getDataValidade());
        orcamento.setStatus(dto.getStatus());
        orcamento.setObservacoes(dto.getObservacoes());

        Orcamento novoOrcamento = service.cadastrar(orcamento, dto.getClienteId());
        return new ResponseEntity<>(new OrcamentoResponseDTO(novoOrcamento), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrcamentoListResponseDTO>> listar() {
        List<Orcamento> orcamentos = service.listarTodos();
        List<OrcamentoListResponseDTO> dtos = orcamentos.stream()
            .map(OrcamentoListResponseDTO::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoResponseDTO> buscarPorId(@PathVariable Long id) {
        Orcamento orcamento = service.buscarPorId(id);
        return ResponseEntity.ok(new OrcamentoResponseDTO(orcamento));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<OrcamentoListResponseDTO>> listarPorCliente(@PathVariable Long clienteId) {
        List<Orcamento> orcamentos = service.listarPorCliente(clienteId);
        List<OrcamentoListResponseDTO> dtos = orcamentos.stream()
            .map(OrcamentoListResponseDTO::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrcamentoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody OrcamentoUpdateDTO dto) {
        
        Orcamento orcamento = new Orcamento();
        orcamento.setDescricao(dto.getDescricao());
        orcamento.setValor(dto.getValor());
        orcamento.setDataOrcamento(dto.getDataOrcamento());
        orcamento.setDataValidade(dto.getDataValidade());
        orcamento.setStatus(dto.getStatus());
        orcamento.setObservacoes(dto.getObservacoes());

        Orcamento orcamentoAtualizado = service.atualizar(id, orcamento);
        return ResponseEntity.ok(new OrcamentoResponseDTO(orcamentoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}