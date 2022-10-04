package com.cancer.controller.cadastro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cancer.controller.home.TelaInicialController;
import com.cancer.repository.cadastro.TipoUsuarioRepository;
import com.cancer.validacoes.ValidacoesUsuario;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = CadastroController.ROUTE)
@PageTitle("Cadastro")
public class CadastroController extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4824780765428606387L;

	public static final String ROUTE = "app-cadastro";
	

	private List<String> items = new ArrayList<>(
			Arrays.asList(TipoUsuarioRepository.MEDICO.getDescricao(), TipoUsuarioRepository.SECRETARIA.getDescricao()));
	private Icon checkIcon;
	private Span passwordStrengthText;
	private TextField primeiroNome;
	TextField crmText;

	public CadastroController() {

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(Alignment.CENTER);

		getStyle().set("background-color", "var(--lumo-contrast-5pct)").set("margin", "50");

		ComboBox<String> comboBox = new ComboBox<>("Usuário");
		comboBox.setAllowCustomValue(true);
		comboBox.setItems(items);
		
		crmText = new TextField("Crm");
		crmText.setEnabled(false);
		
		comboBox.addValueChangeListener(e -> crmValidador(e.getValue()));
		
		add(new HorizontalLayout(comboBox, crmText));

		primeiroNome = new TextField("Nome");
		primeiroNome.setPlaceholder("João");
		primeiroNome.setWidth(250, Unit.PIXELS );

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
		checkIcon = VaadinIcon.CHECK.create();
		checkIcon.setVisible(false);
		checkIcon.getStyle().set("color", "var(--lumo-success-color)");
		passwordField.setSuffixComponent(checkIcon);

		Div passwordStrength = new Div();
		passwordStrengthText = new Span();
		passwordStrength.add(new Text("Força da senha: "), passwordStrengthText);
		passwordField.setHelperComponent(passwordStrength);
		passwordField.setValueChangeMode(ValueChangeMode.EAGER);
		passwordField.addValueChangeListener(e -> updateHelper(e.getValue()));

		updateHelper("");

		PasswordField confirmPassword = new PasswordField("Confirmar senha");
		confirmPassword.setHelperText("Uma senha deve ter pelo menos 8 caracteres. Tem que ter pelo menos uma letra e um dígito.");
		confirmPassword.setErrorMessage("Não é uma senha válida");
		confirmPassword.setWidth(250, Unit.PIXELS);
		add(new HorizontalLayout(passwordField, confirmPassword));
		
		ValidacoesUsuario validar = new ValidacoesUsuario();
		
		Button btnCadastrar = new Button("Criar conta");
		btnCadastrar.setWidth(250, Unit.PIXELS);
		btnCadastrar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnCadastrar.addClickListener(click -> validar.validarCampos(crmText.getValue(), comboBox.getValue(), primeiroNome.getValue(), sobrenome.getValue(), telefone.getValue(), dataNascimento.getValue(), 
				email.getValue(), cpf.getValue(), passwordField.getValue(), confirmPassword.getValue()));

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setWidth(250, Unit.PIXELS);
		btnCancelar.addClickListener(click -> btnCancelar.getUI().ifPresent(ui -> ui.navigate(TelaInicialController.ROUTE)));
		add(new HorizontalLayout(btnCadastrar, btnCancelar));

	}
	
	private void limpaCampos() {
		primeiroNome.setValue("");
	}
	
	private void crmValidador(String combo) {
		if(combo.equals("Médico(a)")) {
			crmText.setEnabled(true);
		}else {
			crmText.setEnabled(false);
		}
	}

	private void updateHelper(String password) {
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
		cadastrar.addClickListener(click -> cadastrar.getUI().ifPresent(ui -> ui.navigate(TelaInicialController.ROUTE)));
	}

}
