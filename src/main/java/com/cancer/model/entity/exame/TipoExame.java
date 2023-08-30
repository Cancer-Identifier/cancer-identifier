package com.cancer.model.entity.exame;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_EXAME")
public class TipoExame {
	
	@Id
	@Column(name = "ID_TIPO")
	private Long idTipo;
	
	@Column(name = "DESCRICAO")
	private String descricao;

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
