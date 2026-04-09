package com.imber.sistema.dto.cliente;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class ClienteUpdateDTO {

	@NotBlank
	@Size(min = 3, max = 150)
	private String nomeCompleto;
	
	@Past
	private LocalDate dataNascimento;
	
	@NotBlank
	private String telefone;
	
	@Email
	private String email;
	
	private Boolean possuiNomeSujo;
	
	private Boolean possuiCredito;
	
	private String observacoes;
	
	private Boolean ativo;

	/*
		GET AND SETERS
	*/

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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
	
}
