package com.cancer.controller.cadastro;


import com.cancer.controller.home.TelaInicialController;
import com.cancer.validacoes.ValidacoesEsqueceuSenha;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = EsquecerSenhaController.ROUTE)
@PageTitle("Recuperação de Senha")
public class EsquecerSenhaController extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1387369252734935061L;
	
	public static final String ROUTE = "esqueci-senha";

	public EsquecerSenhaController() {

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(Alignment.CENTER);

		H1 recuperacao = new H1("Recuperação de Senha");
		recuperacao.getStyle().set("color", "#A34CD8");
		add(recuperacao);

		TextField esqueceu = new TextField("Insira o email para a redefinição de senha");
		esqueceu.getStyle().set("color", "#A34CD8");
		esqueceu.setPlaceholder("E-mail");
		esqueceu.setWidth(350, Unit.PIXELS);
		add(esqueceu);
		
		Button enviar = new Button("Enviar");
		enviar.setWidth(120, Unit.PIXELS);
		
		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setWidth(100, Unit.PIXELS);
		btnCancelar.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
		btnCancelar.addClickListener(click -> btnCancelar.getUI().ifPresent(ui -> ui.navigate(TelaInicialController.ROUTE)));
		
		ValidacoesEsqueceuSenha valida = new ValidacoesEsqueceuSenha();
		
		enviar.addClickListener(click -> valida.validarCampos(esqueceu.getValue()));
		
		add(new HorizontalLayout(enviar, btnCancelar));
		
		Text enviaremos = new Text("Enviaremos e-mail para prosseguir com alteração de senha!");
		add(enviaremos);
	}

}
