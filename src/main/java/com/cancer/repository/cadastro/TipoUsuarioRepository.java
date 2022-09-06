package com.cancer.repository.cadastro;

public enum TipoUsuarioRepository {

	SECRETARIA(1, "Secretário(a)"),
	MEDICO(2, "Médico(a)");
	
	private int codigo;
	private String descricao;
	
	private TipoUsuarioRepository(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
}
