package com.cancer.validacoes;

import com.cancer.controller.cadastro.CadastroController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;

public class ValidacoesEsqueceuSenha {
	
	public void validarCampos(String esqueceuSenha) {
		
		int error = 0;
		
		if(esqueceuSenha == "" || esqueceuSenha.isEmpty() || esqueceuSenha == null) {
			Dialog dialog = new Dialog();

	        dialog.add("Digite um E-mail valido.     ");

	        Button okButton = new Button("OK", (e) -> dialog.close());
	        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
	        dialog.add(okButton);

	        dialog.open();
	        error ++;
		}
		
		
		if(error == 0) {
			CadastroController cadastro = new CadastroController();
			Dialog dialog = new Dialog();

	        dialog.add("E-mail enviado!     ");

	        Button okButton = new Button("OK", (e) -> dialog.close());
	        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	        dialog.add(okButton);
	        cadastro.cadastrar(okButton);

	        dialog.open();
		}
		
	}
}
