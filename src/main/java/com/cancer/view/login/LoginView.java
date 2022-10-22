package com.cancer.view.login;

import com.cancer.controller.home.TelaInicialController;
import com.cancer.view.cadastro.EsquecerSenhaView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = LoginView.ROUTE)
@PageTitle("Login")
public class LoginView extends VerticalLayout {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 7404060613241971454L;
	
	public static final String ROUTE = "";

	public LoginView() {
		
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
        loginForm.addForgotPasswordListener(e -> loginForm.getUI().ifPresent(ui -> ui.navigate(EsquecerSenhaView.ROUTE)));
        loginForm.setI18n(i18n);
        
        loginForm.addLoginListener(event -> {
        	if("user".equals(event.getUsername())) {
        		if("123".equals(event.getPassword())) {
        			UI.getCurrent().navigate(TelaInicialController.ROUTE);
        		} else {
            		Notification.show("Usuário ou senha inválidos!");
            		loginForm.setEnabled(true);
            	}
        	} else {
        		Notification.show("Usuário ou senha inválidos!");
        		loginForm.setEnabled(true);
        	}
        	
        });
        
        add(loginForm);
    }
}
