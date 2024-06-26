package com.cancer.model.entity.cadastro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PACIENTES")
public class Paciente {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "RG")
	private Long rg;
	
	@Column(name = "CPF")
	private Long cpf;
	
	@Column(name = "DATA_NASCIMENTO")
	private Date dataNascimento;
	
	@Column(name = "ENDERECO")
	private String endero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndero() {
		return endero;
	}

	public void setEndero(String endero) {
		this.endero = endero;
	}
	
}
