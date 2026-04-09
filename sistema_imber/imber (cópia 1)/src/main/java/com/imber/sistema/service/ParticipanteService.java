package com.imber.sistema.service;

import com.imber.sistema.entity.Participante;
import com.imber.sistema.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParticipanteService {

    private final ParticipanteRepository repository;

    public ParticipanteService(ParticipanteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Participante cadastrar(Participante participante) {
        if (repository.findByCpf(participante.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado!");
        }
        if (repository.findByEmail(participante.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado!");
        }
        if (Boolean.TRUE.equals(participante.getPossuiNecessidadeEspecial())
                && (participante.getDescricaoNecessidade() == null 
                || participante.getDescricaoNecessidade().isBlank())) {
            throw new RuntimeException("Descrição da necessidade especial é obrigatória!");
        }

        participante.setAtivo(true);
        participante.setDataCadastro(LocalDateTime.now());
        return repository.save(participante);
    }

    public List<Participante> listarTodos() {
        return repository.findAll();
    }

    public Participante buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participante não encontrado"));
    }

    public Participante buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Participante não encontrado"));
    }

    @Transactional
    public Participante atualizar(Long id, Participante participanteAtualizado) {
        Participante participanteExistente = buscarPorId(id);

        if (!participanteAtualizado.getEmail().equals(participanteExistente.getEmail())
                && repository.findByEmail(participanteAtualizado.getEmail()).isPresent()) {
            throw new RuntimeException("Email já em uso!");
        }

        participanteExistente.setNomeCompleto(participanteAtualizado.getNomeCompleto());
        participanteExistente.setDataNascimento(participanteAtualizado.getDataNascimento());
        participanteExistente.setTelefone(participanteAtualizado.getTelefone());
        participanteExistente.setTelefoneEmergencia(participanteAtualizado.getTelefoneEmergencia());
        participanteExistente.setEmail(participanteAtualizado.getEmail());
        participanteExistente.setProfissao(participanteAtualizado.getProfissao());
        participanteExistente.setInteresses(participanteAtualizado.getInteresses());
        participanteExistente.setReceberInformativos(participanteAtualizado.getReceberInformativos());
        participanteExistente.setPossuiNecessidadeEspecial(participanteAtualizado.getPossuiNecessidadeEspecial());
        participanteExistente.setDescricaoNecessidade(participanteAtualizado.getDescricaoNecessidade());
        participanteExistente.setObservacoes(participanteAtualizado.getObservacoes());

        return repository.save(participanteExistente);
    }

    @Transactional
    public void deletar(Long id) {
        Participante participante = buscarPorId(id);
        participante.setAtivo(false);
        repository.save(participante);
    }
}