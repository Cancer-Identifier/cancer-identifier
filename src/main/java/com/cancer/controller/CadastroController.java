package com.cancer.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("app-cadastro")
public class CadastroController extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	private Grid<Integer> grid = new Grid<>();
	
	private List<String> items = new ArrayList<>(Arrays.asList("Secretário(a)", "Médico(a)"));
	private Icon checkIcon;
	private Span passwordStrengthText;

	public CadastroController() {
		
		getStyle()
			.set("background-color", "var(--lumo-contrast-5pct)")
			.set("margin", "50");
		
	    TextField firstName = new TextField("Nome");
	    TextField lastName = new TextField("Sobrenome");
	    TextField username = new TextField("Nome de usuário");
	    TextField crm = new TextField("Crm");
	    TextField email = new TextField("E-mail");
	    NumberField number = new NumberField("Telefone");
	    NumberField cpf = new NumberField("CPF");
	    TextField data = new TextField("Data de Nascimento");
	    
	    PasswordField passwordField = new PasswordField();
	    passwordField.setLabel("Senha");
	    passwordField.setRevealButtonVisible(false);
	    
	    passwordField.setHelperText("Uma senha deve ter pelo menos 8 caracteres. Tem que ter pelo menos uma letra e um dígito.");
	    passwordField.setPattern("^(?=.*[0-9])(?=.*[a-zA-Z]).{8}.*$");
	    passwordField.setErrorMessage("Não é uma senha válida");	

	    checkIcon = VaadinIcon.CHECK.create();
	    checkIcon.setVisible(false);
	    checkIcon.getStyle().set("color", "var(--lumo-success-color)");
	    passwordField.setSuffixComponent(checkIcon);

	    Div passwordStrength = new Div();
	    passwordStrengthText = new Span();
	    passwordStrength.add(new Text(" Força da senha: "), passwordStrengthText);
	    passwordField.setHelperComponent(passwordStrength);

	    add(passwordField);

	    passwordField.setValueChangeMode(ValueChangeMode.EAGER);
	    passwordField.addValueChangeListener(e -> {
	      String password = e.getValue();
	      updateHelper(password);
	    });

	    updateHelper("");
	    
	    PasswordField confirmPassword = new PasswordField("Confirmar senha");
	    
	    
	    ComboBox<String> comboBox = new ComboBox<>("Usuário");
	    comboBox.setAllowCustomValue(true);
	    comboBox.addCustomValueSetListener(e -> {
	      String customValue = e.getDetail();
	      items.add(customValue);
	      comboBox.setItems(items);
	      comboBox.setValue(customValue);
	    });
	    add(comboBox);
	    comboBox.setItems(items);
	    comboBox.setHelperText("Selecione o usuário de registro");
	    
	    FormLayout formLayout = new FormLayout();
	    crm.setEnabled(false);
	    formLayout.add(
	            firstName, lastName,
	            username, crm,
	            number, email,
	            data, cpf,
	            passwordField, confirmPassword
	    );
	    formLayout.setResponsiveSteps(
	            new ResponsiveStep("0", 1),
	            new ResponsiveStep("150px", 2)
	    );
	    formLayout.setColspan(crm, 1);
	    
	    Button createAccount = new Button("Criar conta");
        createAccount.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Button cancel = new Button("Cancelar");

        HorizontalLayout buttonLayout = new HorizontalLayout(createAccount, cancel);

        setPadding(false);
        add(formLayout, buttonLayout);
        
        
        
        grid.addColumn(i -> i).setHeader("Number"); 
        grid.addColumn(i -> new Image("../theme/ajax-loader.gif", "alt text")).setHeader("Preview");
    	grid.setItems(IntStream.range(1,21).boxed());
	    
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

}
