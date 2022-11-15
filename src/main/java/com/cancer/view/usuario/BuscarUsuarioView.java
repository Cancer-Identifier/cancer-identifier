package com.cancer.view.usuario;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = BuscarUsuarioView.ROUTE)
@PageTitle("Buscar Usuário")
public class BuscarUsuarioView extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ROUTE = "app-buscar-paciente";

}
