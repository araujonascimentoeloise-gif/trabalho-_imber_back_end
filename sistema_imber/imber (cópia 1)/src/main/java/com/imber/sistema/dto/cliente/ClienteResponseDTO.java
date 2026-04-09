package com.imber.sistema.dto.cliente;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClienteResponseDTO {

	private Long id;
	private String nomeCompleto;
	private String cpf;
	private String rg;
	private LocalDate dataNascimento;
	private String telefone;
	private String segundoTelefone;
	private String redesSociais;
	private String email;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private Boolean possuiLaudomedico;
	private Boolean possuiNomeSujo;
	private Boolean possuiCredito;
	private String observacoes;
	private Boolean ativo;
	private LocalDateTime dataCadastro;

public ClienteResponseDTO( 
	Long id,
	String nomeCompleto,
	String cpf,
	String rg,
	LocalDate dataNascimento,
    String telefone,
	String segundoTelefone,
	String redesSociais, 
	String email,
	String rua,
	String numero,
	String bairro,
	String cidade,
	String estado,
	String cep,
	Boolean possuiLaudomedico,
	Boolean possuiNomeSujo,
	Boolean possuiCredito,
	String observacoes,
	Boolean ativo,
	LocalDateTime dataCadastro) {
	
	this.id = id;
	this.nomeCompleto = nomeCompleto;
	this.cpf = cpf;
	this.rg = rg;
	this.dataNascimento = dataNascimento;
	this.telefone = telefone;
	this.segundoTelefone = segundoTelefone;
	this.redesSociais = redesSociais;
	this.email = email;
	this.rua = rua;
	this.numero = numero;
	this.bairro = bairro;
	this.cidade = cidade;
    this.estado = estado;
	this.cep = cep;
	this.possuiLaudomedico = possuiLaudomedico;
	this.possuiNomeSujo = possuiNomeSujo;
	this.possuiCredito = possuiCredito;
	this.observacoes = observacoes;
	this.ativo = ativo;
	this.dataCadastro = dataCadastro;
}
public Long getId() {
	return id;
}

public String getNomeCompleto() {
	return nomeCompleto;
}

public String getCpf() {
	return cpf;
}

public String getRg() {
	return rg;
}

public LocalDate getDataNascimento() {
	return dataNascimento;
}

public String getTelefone() {
	return telefone;
}

public String getSegundoTelefone() {
	return segundoTelefone;
}

public String getRedesSociais() {
	return redesSociais;
}

public String getEmail() {
	return email;
}

public String getRua() {
    return rua;
}

public String getNumero() {
    return numero;
}

public String getBairro() {
    return bairro;
}

public String getCidade() {
    return cidade;
}

public String getEstado() {
    return estado;
}

public String getCep() {
    return cep;
}

public Boolean getPossuiLaudomedico() {
    return possuiLaudomedico;
}

public Boolean getPossuiNomeSujo() {
	return possuiNomeSujo;
}

public Boolean getPossuiCredito() {
	return possuiCredito;
}

public String getObservacoes() {
	return observacoes;
}

public Boolean getAtivo() {
	return ativo;
}

public LocalDateTime getDataCadastro() {
	return dataCadastro;
}

public void setId(Long id) {
	this.id = id;
}

public void setNomeCompleto(String nomeCompleto) {
	this.nomeCompleto = nomeCompleto;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public void setRg(String rg) {
	this.rg = rg;
}

public void setDataNascimento(LocalDate dataNascimento) {
	this.dataNascimento = dataNascimento;
}

public void setTelefone(String telefone) {
	this.telefone = telefone;
}

public void setSegundoTelefone(String segundoTelefone) {
	this.segundoTelefone = segundoTelefone;
}

public void setRedesSociais(String redesSociais) {
	this.redesSociais = redesSociais;
}

public void setEmail(String email) {
	this.email = email;
}

public void setRua(String rua) {
	this.rua = rua;
}

public void setNumero(String numero) {
	this.numero = numero;
}

public void setBairro(String bairro) {
	this.bairro = bairro;
}

public void setCidade(String cidade) {
	this.cidade = cidade;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public void setCep(String cep) {
	this.cep = cep;
}

public void setPossuiNomeSujo(Boolean possuiNomeSujo) {
	this.possuiNomeSujo = possuiNomeSujo;
}

public void setPossuiCredito(Boolean possuiCredito) {
	this.possuiCredito = possuiCredito;
}

public void setPossuiLaudomedico(Boolean possuiLaudomedico) {
	this.possuiLaudomedico = possuiLaudomedico;
}

public void setObservacoes(String observacoes) {
	this.observacoes = observacoes;
}

public void setAtivo(Boolean ativo) {
	this.ativo = ativo;
}

public void setDataCadastro(LocalDateTime dataCadastro) {
	this.dataCadastro = dataCadastro;
}
}
