package com.cancer.view.cadastro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cancer.model.entity.cadastro.Bairro;
import com.cancer.model.service.cadastro.BairroService;
import com.cancer.model.service.cadastro.ImagemService;
import com.cancer.view.home.TelaInicialView;
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

@Route(value = PesquisaBairroView.ROUTE)
@PageTitle("Pesquisar Bairro")
public class PesquisaBairroView extends VerticalLayout {
	

	private static final long serialVersionUID = -4342722110494292850L;

	private static final String ROUTE = "app-pesquisa-bairro";
	
	@Autowired
    private BairroService bairroService;
	
	@Autowired
    private ImagemService imagemService;
	
	private NumberField nomeBairro;
	private TextField nomeResultado;
	private Button delete;
	private Button btnEditar;

	public PesquisaBairroView() {

		H1 titulo = new H1("Pesquisa Bairro");
		titulo.getStyle().set("color", "#A34CD8");
		add(titulo);

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(Alignment.CENTER);
		getStyle().set("background-color", "var(--lumo-contrast-5pct)").set("margin", "50");
		
		nomeBairro = new NumberField("Número do Bairro");
		nomeBairro.setWidth(500, Unit.PIXELS);
		add(nomeBairro);
		
		nomeResultado = new TextField("Resultado");
		nomeResultado.setWidth(500, Unit.PIXELS);
		
		btnEditar = new Button("Editar");
		btnEditar.setWidth(150, Unit.PIXELS);
		btnEditar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnEditar.addClickListener(e -> editar());
		btnEditar.setVisible(false);
		
		add(nomeResultado, btnEditar);

		Button btnPesquisar = new Button("Pesquisar");
		btnPesquisar.setWidth(250, Unit.PIXELS);
		btnPesquisar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnPesquisar.addClickListener(e -> pesquisar());
		
		delete = new Button("Deletar");
		delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
		delete.addClickListener(e -> deletar());
		
		

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setWidth(250, Unit.PIXELS);
		btnCancelar.addClickListener(click -> btnCancelar.getUI().ifPresent(ui -> ui.navigate(TelaInicialView.ROUTE)));
		
		add(new HorizontalLayout(btnPesquisar, btnCancelar));
		add(new HorizontalLayout(delete));
	}
	
	public void pesquisar() {
		
		Long numero = nomeBairro.getValue().longValue();
		
		Optional<Bairro> pesquisa = bairroService.pesquisarPorId(numero);
		nomeResultado.setValue(pesquisa.get().getDescricao());
		if(pesquisa != null) {
			btnEditar.setVisible(true);
		}
	}
	
	public void editar() {
		Long numero = nomeBairro.getValue().longValue();
		
		Optional<Bairro> pesquisa = bairroService.pesquisarPorId(numero);
		pesquisa.get().setDescricao(nomeResultado.getValue());
		bairroService.editarBairro(pesquisa);
		
		btnEditar.setVisible(false);
		limpar();
	}
	
	public void deletar() {
		
		Long numero = nomeBairro.getValue().longValue();
		
		bairroService.deletarPorId(numero);
		limpar();
	}
	
	public void limpar() {
		nomeBairro.clear();
		nomeResultado.clear();
	}

	public static String getRoute() {
		return ROUTE;
	}
	
}
