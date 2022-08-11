package com.cancer.controller;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("app-cadastro")
public class CadastroController extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	public CadastroController() {
	    TextField firstName = new TextField("Nome");
	    TextField lastName = new TextField("Sobrenome");
	    TextField username = new TextField("Nome de usuário");
	    PasswordField password = new PasswordField("Senha");
	    PasswordField confirmPassword = new PasswordField("Confirmar senha");

	    FormLayout formLayout = new FormLayout();
	    formLayout.add(
	            firstName, lastName,
	            username,
	            password, confirmPassword
	    );
	    formLayout.setResponsiveSteps(
	            new ResponsiveStep("0", 1),
	            new ResponsiveStep("500px", 2)
	    );
	    formLayout.setColspan(username, 2);

	    add(formLayout);
	}

}
