package com.cancer.controller.cadastro;

import java.io.Serializable;

import com.cancer.controller.home.TelaInicialController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.PasswordField;

public class CadastroController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7062986350074324599L;
	
	public CadastroController() {
		super();
	}

	public void updateHelper(String password, Span passwordStrengthText, PasswordField passwordField) {
		Icon checkIcon = VaadinIcon.CHECK.create();
		checkIcon.setVisible(false);
		checkIcon.getStyle().set("color", "var(--lumo-success-color)");
		passwordField.setSuffixComponent(checkIcon);
		if (password.length() > 9) {
			passwordStrengthText.setText("Forte");
			passwordStrengthText.getStyle().set("color", "var(--lumo-success-color)");
			checkIcon.setVisible(true);
		} else if (password.length() > 5) {
			passwordStrengthText.setText("Moderada");
			passwordStrengthText.getStyle().set("color", "#e7c200");
			checkIcon.setVisible(false);
		} else {
			passwordStrengthText.setText("Fraca");
			passwordStrengthText.getStyle().set("color", "var(--lumo-error-color)");
			checkIcon.setVisible(false);
		}
	}
	
	public void cadastrar(Button cadastrar) {
		cadastrar.addClickListener(click -> cadastrar.getUI().ifPresent(ui -> ui.navigate(TelaInicialController.ROUTE)));
	}

}
