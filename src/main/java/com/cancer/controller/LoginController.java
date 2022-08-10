package com.cancer.controller;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("Login")
public class LoginController extends VerticalLayout {
	
	public LoginController() {
		VerticalLayout layout = new VerticalLayout();
		TextField txtUsuario = new TextField("usuario", "Nome de Usuario");
		PasswordField txtSenha = new PasswordField("senha", "Senha");
		Button btnLogar = new Button("Login");
		
		layout.add(txtUsuario, txtSenha, btnLogar);
	}
	
	
}
