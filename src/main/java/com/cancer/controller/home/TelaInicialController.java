package com.cancer.controller.home;

import com.cancer.controller.cadastro.CadastroController;
import com.cancer.controller.cadastro.LoginController;
import com.cancer.controller.paciente.CadastrarPacienteController;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
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
		
		Button btnCadastrarPaciente = new Button("Cadastrar paciente");
		btnCadastrarPaciente.setWidth(250, Unit.PIXELS);
		btnCadastrarPaciente.addClickListener(click -> btnCadastrar.getUI().ifPresent(ui -> ui.navigate(CadastrarPacienteController.ROUTE)));
		add(btnCadastrarPaciente);
		
		Button btnBuscarPaciente = new Button("Buscar Paciente");
		btnBuscarPaciente.setWidth(250, Unit.PIXELS);
		btnBuscarPaciente.addClickListener(click -> btnCadastrar.getUI().ifPresent(ui -> ui.navigate(CadastroController.ROUTE)));
		add(btnBuscarPaciente);
		
		Button btnPerfilUsuario = new Button("Perfil do Usuário");
		btnPerfilUsuario.setWidth(250, Unit.PIXELS);
		btnPerfilUsuario.addClickListener(click -> btnCadastrar.getUI().ifPresent(ui -> ui.navigate(CadastroController.ROUTE)));
		add(btnPerfilUsuario);
		
		Button btnConvenios = new Button("Clinicas Conveniadas");
		btnConvenios.setWidth(250, Unit.PIXELS);
		btnConvenios.addClickListener(click -> btnCadastrar.getUI().ifPresent(ui -> ui.navigate(CadastroController.ROUTE)));
		add(btnConvenios);

		Button btnSair = new Button("Sair");
		btnSair.setWidth(150, Unit.PIXELS);
		btnSair.addClickListener(click -> btnSair.getUI().ifPresent(ui -> ui.navigate(LoginController.ROUTE)));
		add(btnSair);
		

	}

}
