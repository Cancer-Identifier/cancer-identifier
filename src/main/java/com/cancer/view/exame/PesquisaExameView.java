package com.cancer.view.exame;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;

@Route(value = PesquisaExameView.ROUTE)
public class PesquisaExameView extends VerticalLayout {

	private static final long serialVersionUID = -4342722110494292850L;

	private static final String ROUTE = "app-pesquisa-exame";

	public PesquisaExameView() {

		H1 titulo = new H1("Pesquisa Imagem");
		titulo.getStyle().set("color", "#A34CD8");
		add(titulo);

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(Alignment.CENTER);
		getStyle().set("background-color", "var(--lumo-contrast-5pct)").set("margin", "50");

		MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
		Upload upload = new Upload(buffer);

		upload.addSucceededListener(event -> {
			String fileName = event.getFileName();
			byte[] byteImg = null;
			
			try {
				byteImg = buffer.getInputStream(fileName).readAllBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.POST(HttpRequest.BodyPublishers.ofByteArray(byteImg))
					.uri(URI.create("http://localhost:8080/somente_imagem"))
					.build();
			
			client.sendAsync(request, BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(System.out::println)
				.join();
		});
		add(upload);

	}

	public static String getRoute() {
		return ROUTE;
	}

}
