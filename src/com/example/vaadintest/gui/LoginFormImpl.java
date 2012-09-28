package com.example.vaadintest.gui;

import java.io.IOException;

import javax.naming.ConfigurationException;

import com.example.vaadintest.gui.generated.LoginForm;
import com.example.vaadintest.util.AppConfig;
import com.vaadin.terminal.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class LoginFormImpl extends LoginForm  implements ILoginForm,Button.ClickListener {
	private int anzVersuche = 0;
	private int maxVersuche;
	ILoginFormListener listener=null;

	
	public LoginFormImpl(ILoginFormListener listener) throws ConfigurationException {
		this.listener=listener;
		maxVersuche=AppConfig.getInst().getConfNumValue("maxVersuche",10);
		getAnmelden().addListener((Button.ClickListener) this);
		getAbbrechen().addListener((Button.ClickListener) this);
	}
	public void resetInput(){
		getTxtBen().setValue(EMPTY);
		getPsw().setValue(EMPTY);
	}
	
	public void setBenError(){
		getTxtBen().setComponentError(new UserError("Falsches Passwort oder falscher Benutzername!"));
	}
	
	public void setPswError(){
		getPsw().setComponentError(new UserError("Falsches Passwort oder falscher Benutzername!"));
	}
	
	public void removeErrors(){
		getTxtBen().setComponentError(null);
		getPsw().setComponentError(null);
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		removeErrors();
		final Button source = event.getButton();
		
		if(anzVersuche > maxVersuche){			
			loginBeenden();
			listener.loginDenied();
		}
		else if (source == getAnmelden()) {
			if (getTxtBen().getValue().equals("Malte") & getPsw().getValue().equals("2malte")){
				anzVersuche += 1;
				loginBeenden();
					try {
						listener.loginOkay((String) getTxtBen().getValue());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			else{
				anzVersuche += 1;
				setBenError();
				setPswError();
				resetInput();
				getTxtBen().focus();
			}
		}
		else if (source== getAbbrechen()){
			loginBeenden();
			listener.loginCanceled();
		}
	}
	

	private final static String EMPTY="";

}
