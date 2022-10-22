package com.cancer.model.cadastro;

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
	
	public int getCodigo() {
		return codigo;
	}
	
	public static TipoUsuarioRepository get(Integer id) {
		if(id == null) return null;
		
		for(TipoUsuarioRepository tipoUsuario : values()) {
			if(tipoUsuario.getCodigo() == id) {
				return tipoUsuario;
			}
		}
		return null;
	}
	
}
