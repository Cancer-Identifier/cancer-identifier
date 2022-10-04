package com.cancer.validacoes;

public class CadastroUsuarioVO {

	private String nome;
	private String sobrenome;
	private Integer telefone;
	private String dataNascimento;
	private String email;
	private Long cpf;
	private String passwordField;
	private String confirmPassword;
	
	public CadastroUsuarioVO(String nome, String sobrenome, Integer telefone, String dataNascimento, String email, 
			Long cpf, String passwordField, String confirmPassword) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.cpf = cpf;
		this.passwordField = passwordField;
		this.confirmPassword = confirmPassword;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(String passwordField) {
		this.passwordField = passwordField;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
