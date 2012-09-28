package com.example.vaadintest;

import java.io.IOException;

import javax.naming.ConfigurationException;

import com.example.vaadintest.gui.ILoginForm;
import com.example.vaadintest.gui.ILoginFormListener;
import com.example.vaadintest.gui.LoginFormFactory;
import com.example.vaadintest.gui.LoginFormImpl;
import com.example.vaadintest.gui.generated.VerlaufList;
import com.example.vaadintest.gui.generated.LoginForm;
import com.example.vaadintest.util.AppConfig;
import com.vaadin.Application;
import com.vaadin.terminal.*;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

public class VaadinloginApplication extends Application implements ILoginFormListener ,Button.ClickListener {	

	private Label label = new Label();
	private Label label1 = new Label();
	private Label label2 = new Label();
	private Button logout = new Button();
	Embedded em = new Embedded("", new ThemeResource("images/logo.png"));
	private VerlaufList verlaufList = new VerlaufList();
	Window mainWindow = new Window("Vaadinlogin Application");
	private ILoginForm loginForm;
	
	@Override
	public void init(){
			setTheme("test");
			setLogoutURL("http://www.schlothauer.de/");
			buildMainWindow("");
			getMainWindow().addWindow(loginForm.getWindow());
			logout.addListener((Button.ClickListener) this);
	}
	
	private void buildMainWindow(String benID) {
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
		label.setCaption("Dein Benutzername: "+ benID);
		layout.addComponent(label);
		layout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
		label1.setCaption("Dein Passwort: Haha das dachtest du wohl!");
		layout.addComponent(label1);
		layout.setComponentAlignment(label1, Alignment.MIDDLE_CENTER);
		try {
			AppConfig.createInst(getProperty("cfgFile"));
			loginForm = LoginFormFactory.createLoginForm(this);
			//
			getLabel2().setCaption("xxxx");
			layout.addComponent(getLabel2());
			layout.setComponentAlignment(getLabel2(), Alignment.MIDDLE_CENTER);
			layout.addComponent(verlaufList);
		}
		catch(ConfigurationException e) {
			//TODO 
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainWindow.addComponent(layout);
		
		setMainWindow(mainWindow);
	}

	

	public Label getLabel2() {
		return label2;
	}

	public void setLabel2(Label label2) {
		this.label2 = label2;
	}
	
	public void loginOkay(String benID) {
		buildMainWindow(benID);
	}

	public void loginCanceled() {
		close();
	}

	public void loginDenied() {
		close();
	}

	public void buttonClick(ClickEvent event) {
		final Button source = event.getButton();
		if (source == logout) {
			close();
		}
		
	}
}
