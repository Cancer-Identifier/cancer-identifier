package com.cancer.controller.cadastro;

import com.cancer.controller.home.TelaInicialController;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = LoginController.ROUTE)
@PageTitle("Login")
public class LoginController extends VerticalLayout {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 7404060613241971454L;
	
	public static final String ROUTE = "";

	public LoginController() {
		
		//TESTEASD

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.START);
		setAlignItems(Alignment.CENTER);
		
		H1 titulo = new H1("CANCER IDENTIFIER");
		titulo.getStyle().set("color", "#A34CD8");
		add(titulo);
		
        LoginForm loginForm = new LoginForm();
        LoginI18n i18n = LoginI18n.createDefault();

        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("Entrar");
        i18nForm.setUsername("Usuário");
        i18nForm.setPassword("Senha");
        i18nForm.setForgotPassword("Esqueceu sua senha");
        loginForm.addForgotPasswordListener(e -> loginForm.getUI().ifPresent(ui -> ui.navigate(EsquecerSenhaController.ROUTE)));
        loginForm.setI18n(i18n);
        
        logar(loginForm);
        
        add(loginForm);
    }

	private void logar(LoginForm loginForm) {
		loginForm.addLoginListener(click -> loginForm.getUI().ifPresent(ui -> ui.navigate(TelaInicialController.ROUTE)));
	}
	
}
