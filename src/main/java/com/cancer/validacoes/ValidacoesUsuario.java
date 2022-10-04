package com.cancer.validacoes;

import com.cancer.controller.cadastro.CadastroController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;

public class ValidacoesUsuario {
	
	public void validarCampos(String crm, String comboBox, String nome, String sobrenome, Double telefone, String dataNascimento, String email,
			Double cpf, String passwordField, String confirmPassword) {
		
		int error = 0;
		
		if(comboBox == "" || comboBox.isEmpty() || comboBox == null) {
			Dialog dialog = new Dialog();

	        dialog.add("Selecione um usuário.     ");

	        Button okButton = new Button("OK", (e) -> dialog.close());
	        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
	        dialog.add(okButton);

	        dialog.open();
	        error ++;
		}
		
		if(comboBox.equals("Médico(a)")) {
			if(crm == "" || comboBox.isEmpty()) {
				Dialog dialog = new Dialog();

		        dialog.add("Digite um CRM válido.     ");

		        Button okButton = new Button("OK", (e) -> dialog.close());
		        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
		        dialog.add(okButton);

		        dialog.open();
		        error ++;
			}
		}
		
		if(nome == "" || nome == null || nome.isEmpty()) {
			Dialog dialog = new Dialog();

	        dialog.add("Nome de usuário não pode estar vazio.     ");

	        Button okButton = new Button("OK", (e) -> dialog.close());
	        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
	        dialog.add(okButton);

	        dialog.open();
	        error ++;
		}
		
		if(sobrenome == "" || sobrenome == null || sobrenome.isEmpty()) {
			Dialog dialog = new Dialog();

	        dialog.add("Sobrenome não pode estar vazio.     ");

	        Button okButton = new Button("OK", (e) -> dialog.close());
	        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
	        dialog.add(okButton);

	        dialog.open();
	        error ++;
		}
		
		String lengthTele = String.valueOf(telefone);
		if(telefone == null || lengthTele.length() < 10) {
			Dialog dialog = new Dialog();

	        dialog.add("Digite o número de telefone (mínimo 10 dígitos).     ");

	        Button okButton = new Button("OK", (e) -> dialog.close());
	        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
	        dialog.add(okButton);

	        dialog.open();
	        error ++;
		}
		
		if(email == "" || email.isEmpty()) {
			Dialog dialog = new Dialog();

	        dialog.add("Digite o e-mail.     ");

	        Button okButton = new Button("OK", (e) -> dialog.close());
	        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
	        dialog.add(okButton);

	        dialog.open();
	        error ++;
		}
		
		String lengthCpf = String.valueOf(cpf);
		if(cpf == null || lengthCpf.length() < 10) {
			Dialog dialog = new Dialog();

	        dialog.add("Digite um CPF válido.     ");

	        Button okButton = new Button("OK", (e) -> dialog.close());
	        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
	        dialog.add(okButton);

	        dialog.open();
	        error ++;
		}
		
		if(passwordField == "" || passwordField.isEmpty() || passwordField.length() < 5) {
			Dialog dialog = new Dialog();

	        dialog.add("Senha deve conter 8 dígitos, incluindo letras e números.     ");

	        Button okButton = new Button("OK", (e) -> dialog.close());
	        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
	        dialog.add(okButton);

	        dialog.open();
	        error ++;
		}
		
		if(!confirmPassword.equals(passwordField)) {
			Dialog dialog = new Dialog();

	        dialog.add("Senhas não podem ser diferentes.     ");

	        Button okButton = new Button("OK", (e) -> dialog.close());
	        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
	        dialog.add(okButton);

	        dialog.open();
	        error ++;
		}
		
		if(error == 0) {
			CadastroController cadastro = new CadastroController();
			Dialog dialog = new Dialog();

	        dialog.add("Usuário cadastrado com sucesso!     ");

	        Button okButton = new Button("OK", (e) -> dialog.close());
	        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	        dialog.add(okButton);
	        cadastro.cadastrar(okButton);

	        dialog.open();
		}
		
	}
}
