package com.imber.sistema.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/*====================================================================
    CLASSE ENTITY - PARTICIPANTE
    Representa a tabela "participantes" no banco de dados
    Armazena dados pessoais de quem se inscreve nos eventos
======================================================================*/

@Entity
@Table(name = "participantes")
public class Participante {

    /*
     * ====================================================================
     * IDENTIFICADOR
     * ======================================================================
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * ====================================================================
     * DADOS PESSOAIS
     * ======================================================================
     */

    @Column(nullable = false, length = 200)
    private String nomeCompleto;

    @Column(unique = true, length = 14)
    private String cpf;

    private LocalDate dataNascimento;

    @Column(length = 20)
    private String telefone;

    @Column(length = 20)
    private String telefoneEmergencia; // Adaptado de segundoTelefone

    @Column(unique = true, length = 100)
    private String email;

    /*
     * ====================================================================
     * ENDEREÇO
     * ======================================================================
     */

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    /*
     * ====================================================================
     * INFORMAÇÕES PROFISSIONAIS/ACADÊMICAS (NOVOS)
     * ======================================================================
     */

    @Column(length = 100)
    private String profissao;

    @Column(length = 500)
    private String interesses; // Áreas de interesse separadas por vírgula

    private Boolean receberInformativos = true;

    /*
     * ====================================================================
     * NECESSIDADES ESPECIAIS (NOVOS)
     * ======================================================================
     */

    private Boolean possuiNecessidadeEspecial = false;

    @Column(length = 500)
    private String descricaoNecessidade;

    @Column(length = 500)
    private String observacoes;

    /*
     * ====================================================================
     * CONTROLE DO SISTEMA
     * ======================================================================
     */

    private Boolean ativo = true;

    private LocalDateTime dataCadastro = LocalDateTime.now();

    /*
     * ====================================================================
     * GETTERS E SETTERS
     * ======================================================================
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefoneEmergencia() {
        return telefoneEmergencia;
    }

    public void setTelefoneEmergencia(String telefoneEmergencia) {
        this.telefoneEmergencia = telefoneEmergencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getInteresses() {
        return interesses;
    }

    public void setInteresses(String interesses) {
        this.interesses = interesses;
    }

    public Boolean getReceberInformativos() {
        return receberInformativos;
    }

    public void setReceberInformativos(Boolean receberInformativos) {
        this.receberInformativos = receberInformativos;
    }

    public Boolean getPossuiNecessidadeEspecial() {
        return possuiNecessidadeEspecial;
    }

    public void setPossuiNecessidadeEspecial(Boolean possuiNecessidadeEspecial) {
        this.possuiNecessidadeEspecial = possuiNecessidadeEspecial;
    }

    public String getDescricaoNecessidade() {
        return descricaoNecessidade;
    }

    public void setDescricaoNecessidade(String descricaoNecessidade) {
        this.descricaoNecessidade = descricaoNecessidade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Participante() {
        // Construtor vazio obrigatório para JPA
    }
}