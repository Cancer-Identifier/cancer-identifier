package com.cancer.model.entity.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BAIRRO")
public class Bairro {

	@Id
    @Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
	
	@Column(name = "DESCRICAO")
    private String descricao;


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
