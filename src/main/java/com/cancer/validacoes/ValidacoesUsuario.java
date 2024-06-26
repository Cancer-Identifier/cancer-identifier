package com.cancer.validacoes;

import com.cancer.view.cadastro.CadastroView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;

public class ValidacoesUsuario {
	
	public void validarCampos(String crm, String comboBox, String nome, Double telefone, String dataNascimento, String email,
			Double cpf, String passwordField, String confirmPassword) {
		
		int error = 0;
		
		if(comboBox == null) {
			String msgErro = "Selecione um usuário.      ";
			dialogBox(msgErro);
			error++;
		}
		
		if(comboBox.equals("Médico(a)") && (crm == null || crm.isEmpty())) {
			String msgErro = "Digite um CRM válido.     ";
			dialogBox(msgErro);
			error++;
		}
		
		if(nome == null || nome.isEmpty()) {
			String msgErro = "Nome de usuário não pode estar vazio.     ";
			dialogBox(msgErro);
			error++;
		}
		
		if(telefone == null || String.valueOf(telefone).length() < 10) {
	    	String msgErro = "Digite o número de telefone (mínimo 10 dígitos).     ";
			dialogBox(msgErro);
			error++;
		}
		
		if(email == null || email.isEmpty()) {
	    	String msgErro = "Digite o e-mail.     ";
			dialogBox(msgErro);
			error++;
		}
		
		if(cpf == null || String.valueOf(cpf).length() < 10) {
	    	String msgErro = "Digite um CPF válido.     ";
			dialogBox(msgErro);
			error++;
		}
		
		if(passwordField.isEmpty() || passwordField.length() < 8) {
	    	String msgErro = "Senha deve conter 8 dígitos, incluindo letras e números.     ";
			dialogBox(msgErro);
			error++;
		}
		
		if(!confirmPassword.equals(passwordField)) {
	        String msgErro = "Senhas não podem ser diferentes.     ";
			dialogBox(msgErro);
			error++;
		}
		
		if(error == 0) {
			CadastroView cadastro = new CadastroView();
			Dialog dialog = new Dialog();

	        dialog.add("Usuário cadastrado com sucesso!     ");

	        Button okButton = new Button("OK", e -> dialog.close());
	        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	        dialog.add(okButton);
	        cadastro.cadastrar(okButton);

	        dialog.open();
		}
		
	}

	private void dialogBox(String msgErro) {
		Dialog dialog = new Dialog();
		dialog.add(msgErro);
		
		Button okButton = new Button("OK", e -> dialog.close());
		okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
		dialog.add(okButton);
		dialog.open();
	}
}
