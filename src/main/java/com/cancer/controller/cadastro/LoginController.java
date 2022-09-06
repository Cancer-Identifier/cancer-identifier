package com.cancer.controller.cadastro;

import com.cancer.home.TelaInicialController;
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
		
		getStyle()
        .set("background", "#A34CD8")
        .set("display", "flex")
        .set("justify-content", "center")
        .set("padding", "var(--lumo-space-l)");

        LoginForm loginForm = new LoginForm();
        LoginI18n i18n = LoginI18n.createDefault();
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.START);
        setAlignItems(Alignment.CENTER);
        
        loginForm.addForgotPasswordListener(e -> loginForm.getUI().ifPresent(ui -> ui.navigate(EsquecerSenha.ROUTE)));
        
        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("Entrar");
        i18nForm.setUsername("Usuário");
        i18nForm.setPassword("Senha");
        i18nForm.setForgotPassword("Esqueceu sua senha");
        
        loginForm.setI18n(i18n);
        add(new H1("CANCER IDENTIFIER"), loginForm);
        
        logar(loginForm);
        
        loginForm.getElement().setAttribute("no-autofocus", "");
        
        
    }

	private void logar(LoginForm loginForm) {
		loginForm.addLoginListener(click -> loginForm.getUI().ifPresent(ui -> ui.navigate(TelaInicialController.ROUTE)));
	}
	
}
