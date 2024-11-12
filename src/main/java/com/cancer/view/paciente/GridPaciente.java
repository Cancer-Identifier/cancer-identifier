package com.cancer.view.paciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cancer.model.entity.cadastro.Paciente;
import com.cancer.model.service.cadastro.PacienteService;
import com.cancer.view.home.TelaInicialView;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = GridPaciente.ROUTE)
@PageTitle("Grid Paciente")
public class GridPaciente extends VerticalLayout {

	@Autowired
    private PacienteService pacienteService;
	
	private static final long serialVersionUID = 1L;
	
	public static final String ROUTE = "grid-paciente";

	   public GridPaciente() {
	        Grid<Paciente> grid = new Grid<>();
	        grid.addColumn(Paciente::getNome).setHeader("Nome");
	        grid.addColumn(Paciente::getDataNascimento).setHeader("Data de Nascimento");
	        grid.addColumn(Paciente::getCpf).setHeader("Cpf");

	        Button btnPesquisar = new Button("Pesquisar");
	        btnPesquisar.setWidth(250, Unit.PIXELS);
	        btnPesquisar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	        
	        this.setSpacing(true);
	        
	        Button btnVoltar= new Button("Voltar");
	        btnVoltar.setWidth(250, Unit.PIXELS);
	        btnVoltar.addThemeVariants(ButtonVariant.LUMO_ERROR);
	        
	        btnPesquisar.addClickListener(click -> {  
	            List<Paciente> pacientes = pacienteService.pesquisarTodos();
	            grid.setItems(pacientes);  
	        });
	        
	        grid.addItemDoubleClickListener(e ->{
	            btnVoltar.getUI().ifPresent(ui -> ui.navigate(EditarPacienteView.ROUTE + "/editarRegistro/" + e.getItem().getId()));
	        });
	        
	        HorizontalLayout buttonLayout = new HorizontalLayout();
	        
	        buttonLayout.setWidth("100%"); 
	        buttonLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
	        btnVoltar.getStyle().set("margin-right", "1300px"); 
	        buttonLayout.add(btnVoltar, btnPesquisar);
	        
	        btnVoltar.addClickListener(click -> {
	        	btnVoltar.getUI().ifPresent(ui -> ui.navigate(TelaInicialView.ROUTE));
	        });
	        
	        add(buttonLayout, grid);
	    }

    public static String getRoute() {
		return ROUTE;
	}
}
