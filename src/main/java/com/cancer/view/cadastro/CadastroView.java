package com.cancer.view.cadastro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cancer.model.repository.cadastro.TipoUsuarioRepository;
import com.cancer.validacoes.ValidacoesUsuario;
import com.cancer.view.home.TelaInicialView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
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

	private static final long serialVersionUID = 8529351529550322503L;
	
	public static final String ROUTE = "app-cadastro-usuario";

	private List<String> items = new ArrayList<>(Arrays.asList(TipoUsuarioRepository.MEDICO.getDescricao(), TipoUsuarioRepository.SECRETARIA.getDescricao()));
	private TextField txtNome;
	private TextField crmText;

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

		txtNome = new TextField("Nome");
		txtNome.setPlaceholder("João");
		txtNome.setWidth(500, Unit.PIXELS);
		add(txtNome);
		
		TextField txtEmail = new TextField("E-mail");
		txtEmail.setWidth(500, Unit.PIXELS);
		txtEmail.setPlaceholder("joao.antonio@cancer.com");
		add(txtEmail);

		NumberField telefone = new NumberField("Telefone");
		telefone.setWidth(156, Unit.PIXELS);
		telefone.setPlaceholder("(xx)xxxxx-xxxx");

		TextField dataNascimento = new TextField("Data de Nascimento");
		dataNascimento.setWidth(156, Unit.PIXELS);
		dataNascimento.setPlaceholder("xx/xx/xxxx");

		NumberField cpf = new NumberField("CPF");
		cpf.setWidth(156, Unit.PIXELS);
		cpf.setPlaceholder("xxx.xxx.xxx-xx");
		add(new HorizontalLayout(telefone, cpf, dataNascimento));

		PasswordField passwordField = new PasswordField("Senha");
		passwordField.setWidth(243, Unit.PIXELS);
		passwordField.setPattern("^(?=.*[0-9])(?=.*[a-zA-Z]).{8}.*$");

		Div passwordStrength = new Div();
		Span passwordStrengthText = new Span();
		passwordStrength.add(new Text("Força da senha: "), passwordStrengthText);
		passwordField.setHelperComponent(passwordStrength);
		passwordField.setValueChangeMode(ValueChangeMode.EAGER);
		passwordField.addValueChangeListener(e -> updateHelper(e.getValue(), passwordStrengthText, passwordField));

		PasswordField confirmPassword = new PasswordField("Confirmar senha");
		confirmPassword.setHelperText("Uma senha deve ter pelo menos 8 caracteres. Tem que ter pelo menos uma letra e um dígito.");
		confirmPassword.setErrorMessage("Não é uma senha válida");
		confirmPassword.setWidth(243, Unit.PIXELS);
		add(new HorizontalLayout(passwordField, confirmPassword));

		ValidacoesUsuario validar = new ValidacoesUsuario();

		Button btnCadastrar = new Button("Criar conta");
		btnCadastrar.setWidth(250, Unit.PIXELS);
		btnCadastrar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnCadastrar.addClickListener(click -> validar.validarCampos(crmText.getValue(), comboBox.getValue(),
				txtNome.getValue(), telefone.getValue(), dataNascimento.getValue(),
				txtEmail.getValue(), cpf.getValue(), passwordField.getValue(), confirmPassword.getValue()));

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setWidth(250, Unit.PIXELS);
		btnCancelar.addClickListener(click -> btnCancelar.getUI().ifPresent(ui -> ui.navigate(TelaInicialView.ROUTE)));
		add(new HorizontalLayout(btnCadastrar, btnCancelar));
	}
	
	public void updateHelper(String password, Span passwordStrengthText, PasswordField passwordField) {
		Icon checkIcon = VaadinIcon.CHECK.create();
		checkIcon.setVisible(false);
		checkIcon.getStyle().set("color", "var(--lumo-success-color)");
		passwordField.setSuffixComponent(checkIcon);
		if (password.length() > 9) {
			passwordStrengthText.setText("Forte");
			passwordStrengthText.getStyle().set("color", "var(--lumo-success-color)");
			checkIcon.setVisible(true);
		} else if (password.length() > 5) {
			passwordStrengthText.setText("Moderada");
			passwordStrengthText.getStyle().set("color", "#e7c200");
			checkIcon.setVisible(false);
		} else {
			passwordStrengthText.setText("Fraca");
			passwordStrengthText.getStyle().set("color", "var(--lumo-error-color)");
			checkIcon.setVisible(false);
		}
	}
	
	public void cadastrar(Button cadastrar) {
		cadastrar.addClickListener(click -> cadastrar.getUI().ifPresent(ui -> ui.navigate(TelaInicialView.ROUTE)));
	}

	public static String getRoute() {
		return ROUTE;
	}
	
}
