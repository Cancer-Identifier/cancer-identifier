package com.cancer.view.home;

import com.cancer.view.cadastro.CadastroBairroView;
import com.cancer.view.cadastro.CadastroView;
import com.cancer.view.cadastro.PesquisaBairroView;
import com.cancer.view.exame.PesquisaExameView;
import com.cancer.view.login.LoginView;
import com.cancer.view.paciente.CadastrarPacienteView;
import com.cancer.view.paciente.GridPaciente;
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
		btnCadastrar.addClickListener(click -> btnCadastrar.getUI().ifPresent(ui -> ui.navigate(CadastroView.getRoute())));
		add(btnCadastrar);
		
		Button btnCadastrarPaciente = new Button("Cadastrar paciente");
		btnCadastrarPaciente.setWidth(250, Unit.PIXELS);
		btnCadastrarPaciente.addClickListener(click -> btnCadastrarPaciente.getUI().ifPresent(ui -> ui.navigate(CadastrarPacienteView.ROUTE)));
		add(btnCadastrarPaciente);
		
		Button btnBuscarPaciente = new Button("Cadastrar Bairro");
		btnBuscarPaciente.setWidth(250, Unit.PIXELS);
		btnBuscarPaciente.addClickListener(click -> btnBuscarPaciente.getUI().ifPresent(ui -> ui.navigate(CadastroBairroView.getRoute())));
		add(btnBuscarPaciente);
		
		Button btnPerfilUsuario = new Button("Perfil do usuário");
		btnPerfilUsuario.setWidth(250, Unit.PIXELS);
		btnPerfilUsuario.addClickListener(click -> btnPerfilUsuario.getUI().ifPresent(ui -> ui.navigate(GridPaciente.getRoute())));
		add(btnPerfilUsuario);
		
		Button btnPesquisa = new Button("Pesquisar Bairro");
		btnPesquisa.setWidth(250, Unit.PIXELS);
		btnPesquisa.addClickListener(click -> btnPesquisa.getUI().ifPresent(ui -> ui.navigate(PesquisaBairroView.getRoute())));
		add(btnPesquisa);
		
		Button btnPesquisaExame = new Button("Pesquisar Exame");
		btnPesquisaExame.setWidth(250, Unit.PIXELS);
		btnPesquisaExame.addClickListener(click -> btnPesquisaExame.getUI().ifPresent(ui -> ui.navigate(PesquisaExameView.getRoute())));
		add(btnPesquisaExame);

		Button btnSair = new Button("Sair");
		btnSair.setWidth(150, Unit.PIXELS);
		btnSair.addClickListener(click -> btnSair.getUI().ifPresent(ui -> ui.navigate(LoginView.ROUTE)));
		add(btnSair);
		
	}

}
