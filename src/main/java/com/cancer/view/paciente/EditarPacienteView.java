package com.cancer.view.paciente;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cancer.model.entity.cadastro.Paciente;
import com.cancer.model.entity.exame.Exame;
import com.cancer.model.service.cadastro.ExameService;
import com.cancer.model.service.cadastro.ImagemService;
import com.cancer.model.service.cadastro.PacienteService;
import com.cancer.validacoes.ValidacoesPaciente;
import com.cancer.view.home.TelaInicialView;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
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
	private TextField email;
	private NumberField telefone;
	private TextField dataNascimento;
	private NumberField cpf;
	private Long hideId;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private TextField descricaoExame;
	private DatePicker dataExame;
	private Upload upload;
	private Image imageRectangle;
	private Image imageRectangleAnali;
	
	@Autowired
    private PacienteService pacienteService;
	
	@Autowired
	private ExameService exameService; 
	
	@Autowired
	private ImagemService imagemService;
	
	public EditarPacienteView() {
        Tab details = new Tab("Geral");

        VerticalLayout detailsLayout = new VerticalLayout();
        detailsLayout.setVisible(true); 

        H1 titulo = new H1("Perfil Paciente");
        titulo.getStyle().set("color", "#A34CD8");
        detailsLayout.add(titulo);

        primeiroNome = new TextField("Nome");
        primeiroNome.setPlaceholder("João");
        primeiroNome.setWidth(500, Unit.PIXELS);
        detailsLayout.add(primeiroNome);

        email = new TextField("E-mail");
        email.setWidth(500, Unit.PIXELS);
        email.setPlaceholder("joao.antonio@cancer.com");
        detailsLayout.add(email);

        telefone = new NumberField("Telefone");
        telefone.setWidth(156, Unit.PIXELS);
        telefone.setPlaceholder("(xx)xxxxx-xxxx");

        dataNascimento = new TextField("Data de Nascimento");
        dataNascimento.setWidth(156, Unit.PIXELS);
        dataNascimento.setPlaceholder("xx/xx/xxxx");

        cpf = new NumberField("CPF");
        cpf.setWidth(156, Unit.PIXELS);
        cpf.setPlaceholder("xxx.xxx.xxx-xx");

        detailsLayout.add(new HorizontalLayout(telefone, cpf, dataNascimento));

        MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        upload = new Upload(buffer);

        upload.addSucceededListener(event -> {
            String fileName = event.getFileName();
            byte[] byteImg = null;

            try {
                byteImg = buffer.getInputStream(fileName).readAllBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }

            imagemService.salvarImagem(byteImg, hideId);
            System.out.println("Imagem salva com sucesso!");
        });
    
        upload.setVisible(false);

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

        detailsLayout.add(new HorizontalLayout(btnSalvar, btnCancelar));

        Tab exame = new Tab("Exame");
        Tab analise = new Tab("Análise");

        VerticalLayout exameLayout = new VerticalLayout();
        exameLayout.add(new H1("Exame do Paciente"));

        descricaoExame = new TextField("Descrição do Exame");
        descricaoExame.setWidth(500, Unit.PIXELS);
        descricaoExame.setPlaceholder("Descreva o exame realizado...");
        exameLayout.add(descricaoExame);

        dataExame = new DatePicker("Data do Exame");
        dataExame.setPlaceholder("Selecione a data do exame");
        exameLayout.add(dataExame);
        exameLayout.add(upload);
        
        imageRectangle = new Image();
        imageRectangle.setWidth("200px");
        imageRectangle.setHeight("200px");
        exameLayout.add(imageRectangle);
        
        Button btnSalvarExame = new Button("Salvar Exame");
        btnSalvarExame.getStyle().set("background-color", "#A34CD8");
        btnSalvarExame.setWidth(200, Unit.PIXELS);
        btnSalvarExame.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnSalvarExame.addClickListener(click -> {
        	exameService.salvarExame(hideId, descricaoExame.getValue(), dataExame.getValue());
		});
        exameLayout.add(btnSalvarExame);

        VerticalLayout analiseLayout = new VerticalLayout();
        analiseLayout.add(new H1("Análise do Exame"));
        
        imageRectangleAnali = new Image();
        imageRectangleAnali.setWidth("450px");
        imageRectangleAnali.setHeight("450px");
        analiseLayout.add(imageRectangleAnali);
        
        Button btnAlaisarExame = new Button("Analisar Exame");
        btnAlaisarExame.getStyle().set("background-color", "#A34CD8");
        btnAlaisarExame.setWidth(200, Unit.PIXELS);
        btnAlaisarExame.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        
        Dialog loadingDialog = new Dialog();
        loadingDialog.add(new H1("Carregando..."));
        loadingDialog.setCloseOnEsc(false);
        loadingDialog.setCloseOnOutsideClick(false);

        btnAlaisarExame.addClickListener(click -> {
            loadingDialog.open();

            getUI().ifPresent(ui -> ui.access(() -> {
                try {
                    Thread.sleep(10000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                loadingDialog.close();
                
                Notification notification = Notification.show("Análise concluída!", 3000, Position.MIDDLE);
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            }));
        });
        
        analiseLayout.add(btnAlaisarExame);

        exameLayout.setVisible(false);
        analiseLayout.setVisible(false);

        Tabs tabs = new Tabs(details, exame, analise);

        tabs.addSelectedChangeListener(event -> {
            detailsLayout.setVisible(false);
            exameLayout.setVisible(false);
            analiseLayout.setVisible(false);

            if (event.getSelectedTab() == details) {
                detailsLayout.setVisible(true);
            } else if (event.getSelectedTab() == exame) {
            	exameLayout.setVisible(true);
            } else if (event.getSelectedTab() == analise) {
            	analiseLayout.setVisible(true);
            }
        });

        add(tabs, detailsLayout, exameLayout, analiseLayout);
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
		hideId = id;
		
		Optional<Exame> exame = exameService.pesquisaExamePorPaciente(id);
		
		primeiroNome.setValue(paciente.get().getNome());
		email.setValue(paciente.get().getEmail());
		telefone.setValue((double) Long.parseLong(paciente.get().getTelefone()));
		cpf.setValue(paciente.get().getCpf().doubleValue());
		
		if(exame.isPresent()) {
			descricaoExame.setValue(exame.get().getDescricao());
			dataExame.setValue(exame.get().getDataExames());
	        upload.setVisible(true);
	        carregarImagemPorExame(exame.get().getId());
		}
		
		Date dataNasc = paciente.get().getDataNascimento();
		String dataFormatada = formatter.format(dataNasc);
		dataNascimento.setValue(dataFormatada);
		
	}
	
	public void carregarImagemPorExame(Long idExame) {
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create("http://localhost:8080/imagem/exame/" + idExame))
	            .build();

	    client.sendAsync(request, HttpResponse.BodyHandlers.ofByteArray())
	            .thenApply(HttpResponse::body)
	            .thenAccept(imageData -> {
	                if (imageData != null && imageData.length > 0) {
	                    String imageUrl = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageData);
	                    imageRectangle.setSrc(imageUrl); // Atualiza o retângulo com a imagem
	                    imageRectangleAnali.setSrc(imageUrl);
	                    upload.setVisible(false);
	                }
	            })
	            .join();
	}


}
