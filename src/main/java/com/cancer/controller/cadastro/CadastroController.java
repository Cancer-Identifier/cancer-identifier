package com.cancer.controller.cadastro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
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
	
	private List<String> items = new ArrayList<>(Arrays.asList(TipoUsuario.MEDICO.getDescricao(), TipoUsuario.SECRETARIA.getDescricao()));
	private Icon checkIcon;
	private Span passwordStrengthText;
	private TextField crm = new TextField("Crm");

	public CadastroController() {
		
		getStyle().set("background-color", "var(--lumo-contrast-5pct)").set("margin", "50");
		
		ComboBox<String> comboBox = new ComboBox<>("Usuário");
		comboBox.setAllowCustomValue(true);
		comboBox.setItems(items);
		add(comboBox);

		TextField firstName = new TextField("Nome");
		firstName.setPlaceholder("João");
		add(firstName);
		
		TextField lastName = new TextField("Sobrenome");
		lastName.setPlaceholder("Antônio");
		add(lastName);
		
		TextField email = new TextField("E-mail");
		email.setPlaceholder("joao.antonio@cancer.com");
		add(email);
		
		NumberField number = new NumberField("Telefone");
		number.setPlaceholder("(xx)xxxxx-xxxx");
		add(number);
		
		NumberField cpf = new NumberField("CPF");
		cpf.setPlaceholder("xxx.xxx.xxx-xx");
		add(cpf);
		
		TextField data = new TextField("Data de Nascimento");
		data.setPlaceholder("xx/xx/xxxx");
		add(data);

		PasswordField passwordField = new PasswordField("Senha");
		passwordField.setHelperText("Uma senha deve ter pelo menos 8 caracteres. Tem que ter pelo menos uma letra e um dígito.");
		passwordField.setPattern("^(?=.*[0-9])(?=.*[a-zA-Z]).{8}.*$");
		passwordField.setErrorMessage("Não é uma senha válida");
		add(passwordField);

		checkIcon = VaadinIcon.CHECK.create();
		checkIcon.setVisible(false);
		checkIcon.getStyle().set("color", "var(--lumo-success-color)");
		passwordField.setSuffixComponent(checkIcon);

		Div passwordStrength = new Div();
		passwordStrengthText = new Span();
		passwordStrength.add(new Text("Força da senha: "), passwordStrengthText);
		passwordField.setHelperComponent(passwordStrength);
		passwordField.addValueChangeListener(e -> updateHelper(e.getValue()));

		updateHelper("");

		PasswordField confirmPassword = new PasswordField("Confirmar senha");
		add(confirmPassword);
		
		Button createAccount = new Button("Criar conta");
		createAccount.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		Button cancel = new Button("Cancelar");

		HorizontalLayout buttonLayout = new HorizontalLayout(createAccount, cancel);
		add(buttonLayout);

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

	private void atualizarCrm(String customValue) {
		if (customValue.equals("Secretário(a)")) {
			crm.setEnabled(false);
		}
	}

}
