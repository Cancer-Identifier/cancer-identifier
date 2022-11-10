package com.cancer.view.home;

import com.cancer.view.cadastro.CadastroView;
import com.cancer.view.login.LoginView;
import com.cancer.view.paciente.CadastrarPacienteView;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = TelaInicialView.ROUTE)
@PageTitle("Tela Inicial")
public class TelaInicialView extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6256171611027213686L;

	public static final String ROUTE = "app-tela-inicial";

	public TelaInicialView() {

		H1 titulo = new H1("CANCER IDENTIFIER");
		titulo.getStyle().set("color", "#A34CD8");
		add(titulo);
		
		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(Alignment.CENTER);

		Button btnCadastrar = new Button("Cadastrar usuário");
		btnCadastrar.setWidth(250, Unit.PIXELS);
		btnCadastrar.addClickListener(click -> btnCadastrar.getUI().ifPresent(ui -> ui.navigate(CadastroView.ROUTE)));
		add(btnCadastrar);
		
		Button btnCadastrarPaciente = new Button("Cadastrar paciente");
		btnCadastrarPaciente.setWidth(250, Unit.PIXELS);
		btnCadastrarPaciente.addClickListener(click -> btnCadastrar.getUI().ifPresent(ui -> ui.navigate(CadastrarPacienteView.ROUTE)));
		add(btnCadastrarPaciente);
		
		Button btnBuscarPaciente = new Button("Busca paciente");
		btnBuscarPaciente.setWidth(250, Unit.PIXELS);
		btnBuscarPaciente.addClickListener(click -> btnCadastrar.getUI().ifPresent(ui -> ui.navigate(CadastroView.ROUTE)));
		add(btnBuscarPaciente);
		
		Button btnPerfilUsuario = new Button("Perfil do usuário");
		btnPerfilUsuario.setWidth(250, Unit.PIXELS);
		btnPerfilUsuario.addClickListener(click -> btnCadastrar.getUI().ifPresent(ui -> ui.navigate(CadastroView.ROUTE)));
		add(btnPerfilUsuario);

		Button btnSair = new Button("Sair");
		btnSair.setWidth(150, Unit.PIXELS);
		btnSair.addClickListener(click -> btnSair.getUI().ifPresent(ui -> ui.navigate(LoginView.ROUTE)));
		add(btnSair);
		
	}

}
