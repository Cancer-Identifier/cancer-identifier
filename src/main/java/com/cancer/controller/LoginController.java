package com.cancer.controller;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("login")
public class LoginController extends VerticalLayout  {

    public LoginController() {
        // Demo purposes only
        getStyle()
            .set("background-color", "var(--lumo-contrast-5pct)")
            .set("display", "flex")
            .set("justify-content", "center")
            .set("padding", "var(--lumo-space-l)");

        // tag::snippet[]
        LoginForm loginForm = new LoginForm();
        
        LoginI18n i18n = LoginI18n.createDefault();
        
        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("Entrar");
        i18nForm.setUsername("Usuário");
        i18nForm.setPassword("Senha");
        i18nForm.setSubmit("Entrar");
        i18nForm.setForgotPassword("Esqueceu sua senha?");
        
        
        Button tertiaryButton = new Button("Cadastre-se");
        tertiaryButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        tertiaryButton.isVisible();
        tertiaryButton.addClickListener(click -> 
        tertiaryButton.getUI().ifPresent(ui -> 
			ui.navigate("app-cadastro")));
        
        loginForm.setI18n(i18n);
        add(loginForm, tertiaryButton);
        
        loginForm.addLoginListener(click -> 
        loginForm.getUI().ifPresent(ui -> 
			ui.navigate("")));
        // end::snippet[]
        // Prevent the example from stealing focus when browsing the documentation
        loginForm.getElement().setAttribute("no-autofocus", "");
    }
}
