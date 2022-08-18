package com.cancer.home;

import com.cancer.controller.cadastro.CadastroController;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = TelaInicial.ROUTE)
@PageTitle("Tela Inicial")
public class TelaInicial extends VerticalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6256171611027213686L;
	
	public static final String ROUTE = "app-tela-inicial";

	public TelaInicial() {
		VerticalLayout todosList = new VerticalLayout();
		TextField taskField = new TextField();
		Button addButton = new Button("Entrar");
		addButton.addClickListener(click -> 
			addButton.getUI().ifPresent(ui -> 
			ui.navigate(CadastroController.ROUTE)));

		addButton.addClickShortcut(Key.ENTER);

		add(new H1("Cancer-Identifier"), todosList, new HorizontalLayout(taskField, addButton));
	}

}
