package com.cancer.model.entity.exame;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cancer.model.entity.cadastro.Paciente;

@Entity
@Table(name = "EXAMES")
public class Exame {
	
	@Id
	@Column(name = "ID_EXAMES")
	private Long id;
	
	@Column(name = "DESCRICAO")
//	@NotNull(message = "Descrição inválida.")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO")
//	@NotNull(message = "Tipo do Exame inválido.")
	private TipoExame tipoExame;
	
	@ManyToOne
	@JoinColumn(name = "ID_PACIENTE")
	private Paciente paciente;
	
	/* * Implementar as entidades * */
	/*@Column(name = "ANEXO")
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

	public TipoExame getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(TipoExame tipoExame) {
		this.tipoExame = tipoExame;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
}
