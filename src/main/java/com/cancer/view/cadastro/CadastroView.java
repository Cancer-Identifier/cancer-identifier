package com.cancer.view.cadastro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cancer.controller.cadastro.CadastroController;
import com.cancer.controller.home.TelaInicialController;
import com.cancer.repository.cadastro.TipoUsuarioRepository;
import com.cancer.validacoes.ValidacoesUsuario;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = CadastroView.ROUTE)
@PageTitle("Cadastro de Usuário")
public class CadastroView  extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8529351529550322503L;
	
	public static final String ROUTE = "app-cadastro-usuario";

	private List<String> items = new ArrayList<>(Arrays.asList(TipoUsuarioRepository.MEDICO.getDescricao(), TipoUsuarioRepository.SECRETARIA.getDescricao()));
	private TextField primeiroNome;
	TextField crmText;
	CadastroController cadastroController = new CadastroController();

	public CadastroView() {

		H1 titulo = new H1("Cadastrar usuário");
		titulo.getStyle().set("color", "#A34CD8");
		add(titulo);

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(Alignment.CENTER);

		getStyle().set("background-color", "var(--lumo-contrast-5pct)").set("margin", "50");

		ComboBox<String> comboBox = new ComboBox<>("Usuário");
		comboBox.setAllowCustomValue(true);
		comboBox.setItems(items);
		comboBox.addValueChangeListener(e -> crmText.setEnabled(comboBox.getValue().equals("Médico(a)")));

		crmText = new TextField("Crm");
		crmText.setEnabled(false);
		add(new HorizontalLayout(comboBox, crmText));

		primeiroNome = new TextField("Nome");
		primeiroNome.setPlaceholder("João");
		primeiroNome.setWidth(250, Unit.PIXELS);

		TextField sobrenome = new TextField("Sobrenome");
		sobrenome.setPlaceholder("Antônio");
		sobrenome.setWidth(250, Unit.PIXELS);
		add(new HorizontalLayout(primeiroNome, sobrenome));

		NumberField telefone = new NumberField("Telefone");
		telefone.setWidth(250, Unit.PIXELS);
		telefone.setPlaceholder("(xx)xxxxx-xxxx");

		TextField dataNascimento = new TextField("Data de Nascimento");
		dataNascimento.setWidth(250, Unit.PIXELS);
		dataNascimento.setPlaceholder("xx/xx/xxxx");
		add(new HorizontalLayout(dataNascimento, telefone));

		TextField email = new TextField("E-mail");
		email.setWidth(300, Unit.PIXELS);
		email.setPlaceholder("joao.antonio@cancer.com");

		NumberField cpf = new NumberField("CPF");
		cpf.setWidth(200, Unit.PIXELS);
		cpf.setPlaceholder("xxx.xxx.xxx-xx");
		add(new HorizontalLayout(email, cpf));

		PasswordField passwordField = new PasswordField("Senha");
		passwordField.setWidth(250, Unit.PIXELS);
		passwordField.setPattern("^(?=.*[0-9])(?=.*[a-zA-Z]).{8}.*$");

		Div passwordStrength = new Div();
		Span passwordStrengthText = new Span();
		passwordStrength.add(new Text("Força da senha: "), passwordStrengthText);
		passwordField.setHelperComponent(passwordStrength);
		passwordField.setValueChangeMode(ValueChangeMode.EAGER);
		passwordField.addValueChangeListener(e -> cadastroController.updateHelper(e.getValue(), passwordStrengthText, passwordField));

		PasswordField confirmPassword = new PasswordField("Confirmar senha");
		confirmPassword.setHelperText("Uma senha deve ter pelo menos 8 caracteres. Tem que ter pelo menos uma letra e um dígito.");
		confirmPassword.setErrorMessage("Não é uma senha válida");
		confirmPassword.setWidth(250, Unit.PIXELS);
		add(new HorizontalLayout(passwordField, confirmPassword));

		ValidacoesUsuario validar = new ValidacoesUsuario();

		Button btnCadastrar = new Button("Criar conta");
		btnCadastrar.setWidth(250, Unit.PIXELS);
		btnCadastrar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnCadastrar.addClickListener(click -> validar.validarCampos(crmText.getValue(), comboBox.getValue(),
				primeiroNome.getValue(), sobrenome.getValue(), telefone.getValue(), dataNascimento.getValue(),
				email.getValue(), cpf.getValue(), passwordField.getValue(), confirmPassword.getValue()));

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setWidth(250, Unit.PIXELS);
		btnCancelar.addClickListener(click -> btnCancelar.getUI().ifPresent(ui -> ui.navigate(TelaInicialController.ROUTE)));
		add(new HorizontalLayout(btnCadastrar, btnCancelar));
	}
	
}
