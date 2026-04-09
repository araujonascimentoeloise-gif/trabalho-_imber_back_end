package com.imber.sistema.service;

import org.springframework.stereotype.Service;
import com.imber.sistema.entity.Participante;
import com.imber.sistema.repository.ClienteRepository;
import java.util.List;

@Service
public class ClienteService {

	private final ClienteRepository repository;
	
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
    }

    public Participante cadastrar(Participante cliente) {
        if (repository.findByCpf(cliente.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }
        return repository.save(cliente);
    }

    public List<Participante> listarTodos() {
        return repository.findAll();
    }
    
    public Participante buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Participante atualizar(Long id, Participante clienteAtualizado) {
        Participante clienteExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

    
        clienteExistente.setNomeCompleto(clienteAtualizado.getNomeCompleto());
        clienteExistente.setCpf(clienteAtualizado.getCpf());
        clienteExistente.setDataNascimento(clienteAtualizado.getDataNascimento());
        clienteExistente.setTelefone(clienteAtualizado.getTelefone());
        clienteExistente.setEmail(clienteAtualizado.getEmail());
        clienteExistente.setRua(clienteAtualizado.getRua());
        clienteExistente.setNumero(clienteAtualizado.getNumero());
        clienteExistente.setBairro(clienteAtualizado.getBairro());
        clienteExistente.setCidade(clienteAtualizado.getCidade());
        clienteExistente.setEstado(clienteAtualizado.getEstado());
        clienteExistente.setCep(clienteAtualizado.getCep());
        clienteExistente.setObservacoes(clienteAtualizado.getObservacoes());
        clienteExistente.setAtivo(clienteAtualizado.getAtivo());

        return repository.save(clienteExistente);
    }
    
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        repository.deleteById(id);
    }
}