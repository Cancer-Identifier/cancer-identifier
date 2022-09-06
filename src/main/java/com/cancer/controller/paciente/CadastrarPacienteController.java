package com.cancer.controller.paciente;

import com.cancer.controller.home.TelaInicialController;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = CadastrarPacienteController.ROUTE)
@PageTitle("Cadastro Paciente")
public class CadastrarPacienteController extends VerticalLayout {
	
	private static final long serialVersionUID = -4192856321203278137L;

	public static final String ROUTE = "app-cadastro-paciente";

	public CadastrarPacienteController() {

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.START);
		setAlignItems(Alignment.CENTER);
		
		H1 titulo = new H1("Cadastrar usuário");
		titulo.getStyle().set("color", "#A34CD8");
		add(titulo);
		
		TextField primeiroNome = new TextField("Nome");
		primeiroNome.setPlaceholder("João");
		primeiroNome.setWidth(300, Unit.PIXELS);

		TextField sobrenome = new TextField("Sobrenome");
		sobrenome.setPlaceholder("Antônio");
		sobrenome.setWidth(300, Unit.PIXELS);
		add(new HorizontalLayout(primeiroNome, sobrenome));

		NumberField telefone = new NumberField("Telefone");
		telefone.setWidth(300, Unit.PIXELS);
		telefone.setPlaceholder("(xx)xxxxx-xxxx");

		TextField dataNascimento = new TextField("Data de Nascimento");
		dataNascimento.setWidth(300, Unit.PIXELS);
		dataNascimento.setPlaceholder("xx/xx/xxxx");
		add(new HorizontalLayout(dataNascimento, telefone));

		TextField email = new TextField("E-mail");
		email.setWidth(400, Unit.PIXELS);
		email.setPlaceholder("joao.antonio@cancer.com");

		NumberField cpf = new NumberField("CPF");
		cpf.setWidth(200, Unit.PIXELS);
		cpf.setPlaceholder("xxx.xxx.xxx-xx");
		add(new HorizontalLayout(email, cpf));

		Button btnCadastrar = new Button("Cadastrar");
		btnCadastrar.getStyle().set("backgroud", "#A34CD8");
		btnCadastrar.setWidth(300, Unit.PIXELS);
		btnCadastrar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.getStyle().set("color", "#A34CD8");
		btnCancelar.setWidth(300, Unit.PIXELS);
		btnCancelar.addClickListener(click -> btnCancelar.getUI().ifPresent(ui -> ui.navigate(TelaInicialController.ROUTE)));
		add(new HorizontalLayout(btnCadastrar, btnCancelar));

	}

}
