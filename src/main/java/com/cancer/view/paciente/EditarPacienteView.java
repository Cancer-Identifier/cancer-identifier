package com.cancer.view.paciente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cancer.model.entity.cadastro.Paciente;
import com.cancer.model.service.cadastro.PacienteService;
import com.cancer.validacoes.ValidacoesPaciente;
import com.cancer.view.home.TelaInicialView;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("app-perfil-paciente/editarRegistro/:id")
@PageTitle("Perfil Paciente")
public class EditarPacienteView extends VerticalLayout implements BeforeEnterObserver {
	

	private static final long serialVersionUID = 1L;
	public static final String ROUTE = "app-perfil-paciente";
	private TextField primeiroNome;
	
	@Autowired
    private PacienteService pacienteService;

	public EditarPacienteView() {

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.START);
		setAlignItems(Alignment.CENTER);
		
		H1 titulo = new H1("Cadastrar usuário");
		titulo.getStyle().set("color", "#A34CD8");
		add(titulo);
		
		primeiroNome = new TextField("Nome");
		primeiroNome.setPlaceholder("João");
		primeiroNome.setWidth(500, Unit.PIXELS);
		add(primeiroNome);
		
		TextField email = new TextField("E-mail");
		email.setWidth(500, Unit.PIXELS);
		email.setPlaceholder("joao.antonio@cancer.com");
		add(email);

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
		
		Button btnSalvar = new Button("Salvar");
		btnSalvar.getStyle().set("backgroud", "#A34CD8");
		btnSalvar.setWidth(300, Unit.PIXELS);
		btnSalvar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		ValidacoesPaciente paciente = new ValidacoesPaciente();
		btnSalvar.addClickListener(click -> {
			paciente.validarCampos(primeiroNome.getValue(), telefone.getValue(), dataNascimento.getValue(), 
					email.getValue(), cpf.getValue());
		});

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.getStyle().set("color", "#A34CD8");
		btnCancelar.setWidth(300, Unit.PIXELS);
		btnCancelar.addClickListener(click -> btnCancelar.getUI().ifPresent(ui -> ui.navigate(TelaInicialView.ROUTE)));
		add(new HorizontalLayout(btnSalvar, btnCancelar));

	}
	
	@Override
    public void beforeEnter(BeforeEnterEvent event) {
        String idParam = event.getRouteParameters().get("id").orElse(null);

        if (idParam != null) {
            try {
                Long id = Long.parseLong(idParam);
                editarRegistro(id); 
            } catch (NumberFormatException e) {
                Notification.show("ID inválido");
            }
        }
    }
	
	public void editarRegistro(Long id) {
		Optional<Paciente> paciente = pacienteService.pesquisarPorId(id);
		primeiroNome.setValue(paciente.get().getNome());
		
	}

}
