package com.example.vaadintest.gui.generated;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.terminal.ErrorMessage;
import com.vaadin.terminal.UserError;
import com.vaadin.ui.*;

public class LoginForm extends Window {
	private Label labelBen= new Label("Benutzer:");
	private Label labelPsw = new Label("Passwort:");
	private TextField txtBen= new TextField();
	private PasswordField psw = new PasswordField();
	private Button anmelden = new Button("Anmelden");
	private Button abbrechen = new Button("Abbrechen");
	
	public LoginForm() {
		setModal(true);
		setWidth("35%");
		setHeight("30%");
		setCaption("Login");
		setClosable(false);
		setDraggable(false);
		setResizable(false);
		buildMainLayout();	
	}
	
	private void buildMainLayout(){
		AbsoluteLayout layout = new AbsoluteLayout();
		layout.setWidth("100%");
		layout.addComponent(labelBen, "top:50.0px;left:60.0px;");
		layout.addComponent(getTxtBen(), "top:50.0px;left:150.0px;");
		getTxtBen().focus();
		layout.addComponent(labelPsw, "top:100.0px;left:60.0px;");
		layout.addComponent(getPsw(), "top:100.0px;left:150.0px;");
		HorizontalLayout layout_1 = new HorizontalLayout();
		layout.addComponent(layout_1, "top:155.0px;left:135.0px;");
		layout_1.addComponent(getAnmelden());
		anmelden.setClickShortcut(KeyCode.ENTER);
		anmelden.addStyleName("primary");
		layout_1.addComponent(getAbbrechen());
		getWindow().setContent(layout);
	}

	public Button getAnmelden() {
		return anmelden;
	}

	public Button getAbbrechen() {
		return abbrechen;
	}

	public TextField getTxtBen() {
		return txtBen;
	}
	

	public PasswordField getPsw() {
		return psw;
	}
	
	
	public void loginBeenden(){
		close();
	}
}
