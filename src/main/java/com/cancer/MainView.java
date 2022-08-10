package com.cancer;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	public MainView() {
		VerticalLayout todosList = new VerticalLayout();
		TextField taskField = new TextField();
		Button addButton = new Button("Addd");
		addButton.addClickListener(click -> 
			addButton.getUI().ifPresent(ui -> 
			ui.navigate("Login")));

		addButton.addClickShortcut(Key.ENTER);

		add(new H1("Arthur Viado"), todosList, new HorizontalLayout(taskField, addButton));
	}
}