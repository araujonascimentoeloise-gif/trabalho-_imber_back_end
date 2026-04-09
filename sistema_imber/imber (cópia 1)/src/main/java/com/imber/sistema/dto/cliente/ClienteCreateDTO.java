package com.imber.sistema.dto.cliente;

import java.time.LocalDate;

public class ClienteCreateDTO {


private String nomeCompleto;
private String cpf;
private LocalDate dataNascimento;
private int rg;
private String telefone;
private String segundoTelefone;
private String redesSociais;
private String email;
private Boolean possuiNomeSujo;
private Boolean possuiCredito;
private Boolean possuiLaudomedico;
private String observacoes;

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

public int getRg() {
	return rg;
}

public void setRg(int rg) {
	this.rg = rg;
}

public String getTelefone() {
	return telefone;
}

public void setTelefone(String telefone) {
	this.telefone = telefone;
}

public String getSegundoTelefone() {
	return segundoTelefone;
}

public void setSegundoTelefone(String segundoTelefone) {
	this.segundoTelefone = segundoTelefone;
}

public String getRedesSociais() {
	return redesSociais;
}

public void setRedesSociais(String redesSociais) {
	this.redesSociais = redesSociais;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Boolean getPossuiNomeSujo() {
	return possuiNomeSujo;
}

public void setPossuiNomeSujo(Boolean possuiNomeSujo) {
	this.possuiNomeSujo = possuiNomeSujo;
}

public Boolean getPossuiCredito() {
	return possuiCredito;
}

public void setPossuiCredito(Boolean possuiCredito) {
	this.possuiCredito = possuiCredito;
}

public Boolean getPossuiLaudomedico() {
	return possuiLaudomedico;
}

public void setPossuiLaudomedico(Boolean possuiLaudomedico) {
	this.possuiLaudomedico = possuiLaudomedico;
}

public String getObservacoes() {
	return observacoes;
}

public void setObservacoes(String observacoes) {
	this.observacoes = observacoes;
}

}
