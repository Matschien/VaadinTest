package com.example.vaadintest.gui;

import com.example.vaadintest.gui.generated.LoginForm;
import com.vaadin.terminal.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class LoginFormComp implements ILoginForm {
	
	private LoginForm inst;
	
	private LoginFormComp() {
		inst=new LoginForm();
	}
	
	public void resetInput(){
		inst.getTxtBen().setValue(EMPTY);
		inst.getPsw().setValue(EMPTY);
	}
	
	public void setBenError(){
		inst.getTxtBen().setComponentError(new UserError("Bring bitte den Müll runter!"));
	}
	
	public void setPswError(){
		inst.getPsw().setComponentError(new UserError("Mach die Musik leiser!"));
	}
	
	public void removeErrors(){
		inst.getTxtBen().setComponentError(null);
		inst.getPsw().setComponentError(null);
	}

	
	public Button getAnmelden() {
		return inst.getAnmelden();
	}

	public Button getAbbrechen() {
		return inst.getAbbrechen();
	}

	public TextField getTxtBen() {
		return inst.getTxtBen();
	}
	

	public PasswordField getPsw() {
		return inst.getPsw();
	}
	
	public Window getWindow() {
		return inst.getWindow();
	}
	
	public void loginBeenden() {
		inst.loginBeenden();
	}
	private final static String EMPTY="";

}
