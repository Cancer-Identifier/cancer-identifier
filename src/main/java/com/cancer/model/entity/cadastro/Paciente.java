package com.cancer.model.entity.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PACIENTES")
public class Paciente {

	@Id
	@Column(name = "ID_PACIENTE")
	private Long id;
	
	@Column(name = "CPF")
	@NotNull(message = "CPF inválida.")
	private String descricao;
	
	@Column(name = "NOME")
	@NotNull(message = "Nome inválida.")
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
