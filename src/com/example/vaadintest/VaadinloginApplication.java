package com.example.vaadintest;

import com.example.vaadintest.gui.ILoginForm;
import com.example.vaadintest.gui.LoginFormComp;
import com.example.vaadintest.gui.LoginFormFactory;
import com.example.vaadintest.gui.LoginFormImpl;
import com.example.vaadintest.gui.generated.VerlaufList;
import com.example.vaadintest.gui.generated.LoginForm;
import com.vaadin.Application;
import com.vaadin.terminal.*;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class VaadinloginApplication extends Application implements Button.ClickListener{
	private Label label = new Label();
	private Label label1 = new Label();
	private Label label2 = new Label();
	private Button logout = new Button();
	Embedded em = new Embedded("", new ThemeResource("images/logo.png"));
	private VerlaufList verlaufList = new VerlaufList();
	Window mainWindow = new Window("Vaadinlogin Application");
	private ILoginForm loginForm = LoginFormFactory.createLoginForm(); // TODO
	private int anzVersuche = 0;
	
	@Override
	public void init() {
		setTheme("test");
		setLogoutURL("http://www.schlothauer.de/");
		buildMainWindow();
		getMainWindow().addWindow(loginForm.getWindow());
		loginForm.getAnmelden().addListener((Button.ClickListener) this);
		loginForm.getAbbrechen().addListener((Button.ClickListener) this);
		logout.addListener((Button.ClickListener) this);
	}
	
	private void buildMainWindow() {
		//"Toolbar" mit Logout-Button & Logo
		HorizontalLayout toolbar = new HorizontalLayout();
		toolbar.setWidth("100%");
		toolbar.setStyleName("toolbar");
		toolbar.addComponent(em);
		toolbar.setComponentAlignment(em, Alignment.BOTTOM_LEFT);
		toolbar.setExpandRatio(em, 1);
		logout.setIcon(new ThemeResource("icons/logout.png"));
		toolbar.addComponent(logout);
		toolbar.setComponentAlignment(logout, Alignment.TOP_RIGHT);
		mainWindow.addComponent(toolbar);
		
		//Verticallayout mit dem Text und der Dongle-Verlaufstabelle
		VerticalLayout layout = new VerticalLayout();
		layout.setWidth("100%");
		layout.setHeight("100%");
		layout.setStyleName("layout");
		label.setCaption("Dein Benutzername: "+ loginForm.getTxtBen().toString());
		label.setContentMode(3);
		layout.addComponent(label);
		layout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
		label1.setCaption("Dein Passwort: "+ loginForm.getPsw().toString());
		label1.setContentMode(3);
		layout.addComponent(label1);
		layout.setComponentAlignment(label1, Alignment.MIDDLE_CENTER);
		getLabel2().setCaption("Du hast genau "+ anzVersuche +" Versuch/e gebraucht, um dich anzumelden!");
		getLabel2().setContentMode(3);
		layout.addComponent(getLabel2());
		layout.setComponentAlignment(getLabel2(), Alignment.MIDDLE_CENTER);
		layout.addComponent(verlaufList);
		mainWindow.addComponent(layout);
		
		setMainWindow(mainWindow);
	}

	
	@Override
	public void buttonClick(ClickEvent event) {
		loginForm.removeErrors();
		final Button source = event.getButton();
		
		if(anzVersuche > 9){
			setLogoutURL("http://www.google.de/");
			close();
		}
		else if (source == loginForm.getAnmelden()) {
			if (loginForm.getTxtBen().toString().equals("Malte") & loginForm.getPsw().toString().equals("2malte")){
				anzVersuche += 1;
				loginForm.loginBeenden();
				buildMainWindow();
			}
			else{
				anzVersuche += 1;
				if(!loginForm.getTxtBen().toString().equals("Malte") && !loginForm.getPsw().toString().equals("2malte")){
					loginForm.setBenError();
					loginForm.setPswError();
				}
				else if(!loginForm.getTxtBen().toString().equals("Malte") && loginForm.getPsw().toString().equals("2malte")){
					loginForm.setBenError();
				}
				else {
					loginForm.setPswError();
				}
				loginForm.resetInput();
				loginForm.getTxtBen().focus();
			}
		}
		else if (source== loginForm.getAbbrechen()){
			close();
		}
		else if (source == logout){
			close();
		}
	}

	public Label getLabel2() {
		return label2;
	}

	public void setLabel2(Label label2) {
		this.label2 = label2;
	}
}
