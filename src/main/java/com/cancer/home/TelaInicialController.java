package com.cancer.home;

import com.cancer.controller.cadastro.CadastroController;
import com.cancer.controller.cadastro.LoginController;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = TelaInicialController.ROUTE)
@PageTitle("Tela Inicial")
public class TelaInicialController extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6256171611027213686L;

	public static final String ROUTE = "app-tela-inicial";

	public TelaInicialController() {

		add(new H1("Cancer-Identifier"));
		
		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(Alignment.CENTER);

		Button btnCadastrar = new Button("Cadastrar usuário");
		btnCadastrar.setWidth(250, Unit.PIXELS);
		btnCadastrar.addClickListener(click -> btnCadastrar.getUI().ifPresent(ui -> ui.navigate(CadastroController.ROUTE)));
		add(btnCadastrar);
		
		Button btnSair = new Button("Sair");
		btnSair.setWidth(250, Unit.PIXELS);
		btnSair.addClickListener(click -> btnSair.getUI().ifPresent(ui -> ui.navigate(LoginController.ROUTE)));
		add(btnSair);

	}

}
