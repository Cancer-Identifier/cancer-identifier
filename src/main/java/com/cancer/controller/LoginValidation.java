package com.cancer.controller;

import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("login-validation")
public class LoginValidation extends Div {

    public LoginValidation() {
        LoginOverlay loginOverlay = new LoginOverlay();
        add(loginOverlay);
        loginOverlay.setOpened(true);
        // Prevent the example from stealing focus when browsing the documentation
        loginOverlay.getElement().setAttribute("no-autofocus", "");
    }
}