package com.imber.sistema.service;

import com.imber.sistema.entity.Orcamento;
import com.imber.sistema.entity.Participante;
import com.imber.sistema.repository.OrcamentoRepository;
import com.imber.sistema.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;
    private final ClienteRepository clienteRepository;

    public OrcamentoService(OrcamentoRepository orcamentoRepository, ClienteRepository clienteRepository) {
        this.orcamentoRepository = orcamentoRepository;
        this.clienteRepository = clienteRepository;
    }

    // CADASTRAR ORÇAMENTO
    public Orcamento cadastrar(Orcamento orcamento, Long clienteId) {
        // Verifica se o cliente existe
        Participante cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + clienteId));

        orcamento.setCliente(cliente);
        return orcamentoRepository.save(orcamento);
    }

    // LISTAR TODOS
    public List<Orcamento> listarTodos() {
        return orcamentoRepository.findAll();
    }

    // BUSCAR POR ID
    public Orcamento buscarPorId(Long id) {
        return orcamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orçamento não encontrado com ID: " + id));
    }

    // LISTAR POR CLIENTE
    public List<Orcamento> listarPorCliente(Long clienteId) {
        // Verifica se o cliente existe (opcional)
        if (!clienteRepository.existsById(clienteId)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        return orcamentoRepository.findByClienteId(clienteId);
    }

    // ATUALIZAR ORÇAMENTO
    public Orcamento atualizar(Long id, Orcamento orcamentoAtualizado) {
        Orcamento orcamentoExistente = buscarPorId(id);

        // Atualiza campos permitidos
        orcamentoExistente.setDescricao(orcamentoAtualizado.getDescricao());
        orcamentoExistente.setValor(orcamentoAtualizado.getValor());
        orcamentoExistente.setDataOrcamento(orcamentoAtualizado.getDataOrcamento());
        orcamentoExistente.setDataValidade(orcamentoAtualizado.getDataValidade());
        orcamentoExistente.setStatus(orcamentoAtualizado.getStatus());
        orcamentoExistente.setObservacoes(orcamentoAtualizado.getObservacoes());

        return orcamentoRepository.save(orcamentoExistente);
    }

    // DELETAR ORÇAMENTO
    public void deletar(Long id) {
        if (!orcamentoRepository.existsById(id)) {
            throw new RuntimeException("Orçamento não encontrado");
        }
        orcamentoRepository.deleteById(id);
    }
}