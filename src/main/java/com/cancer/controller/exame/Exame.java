package com.cancer.controller.exame;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EXAMES")
public class Exame {
	
	@Id
	@Column(name = "ID_EXAMES")
	private Long id;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
/* * Implementar as entidades * */

	/*@Column(name = "ID_TIPO")
	private TipoExame idTipo;
	
	@Column(name = "ID_PACIENTE")
	private Paciente idPaciente;
	
	@Column(name = "ANEXO")
	private byte[] anexo;*/
	
	@Column(name = "DATA_EXAMES")
	private Date dataExames;

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
	
}
