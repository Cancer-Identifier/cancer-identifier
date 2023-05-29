package com.cancer.view.cadastro;

import org.springframework.beans.factory.annotation.Autowired;

import com.cancer.model.service.cadastro.BairroService;
import com.cancer.view.home.TelaInicialView;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = CadastroBairroView.ROUTE)
@PageTitle("Cadastro de Bairro")
public class CadastroBairroView extends VerticalLayout {
	
	@Autowired
	private BairroService bairroService;
	
	private static final long serialVersionUID = -7740129687089752129L;
	
	private static final String ROUTE = "app-cadastro-bairro";
	
	private TextField nomeBairro;

	public CadastroBairroView() {

		H1 titulo = new H1("Cadastrar Bairro");
		titulo.getStyle().set("color", "#A34CD8");
		add(titulo);

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(Alignment.CENTER);
		getStyle().set("background-color", "var(--lumo-contrast-5pct)").set("margin", "50");
		
		nomeBairro = new TextField("Nome do Bairro");
		nomeBairro.setWidth(500, Unit.PIXELS);
		add(nomeBairro);

		Button btnCadastrar = new Button("Cadastrar");
		btnCadastrar.setWidth(250, Unit.PIXELS);
		btnCadastrar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnCadastrar.addClickListener(e -> cadastrar());

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setWidth(250, Unit.PIXELS);
		btnCancelar.addClickListener(click -> btnCancelar.getUI().ifPresent(ui -> ui.navigate(TelaInicialView.ROUTE)));
		
		add(new HorizontalLayout(btnCadastrar, btnCancelar));
	}
	
	public void cadastrar() {
		bairroService.salvarBairro(nomeBairro.getValue());
		nomeBairro.clear();
	}

	public static String getRoute() {
		return ROUTE;
	}
	
}
