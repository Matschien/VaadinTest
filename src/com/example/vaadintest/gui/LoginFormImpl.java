package com.example.vaadintest.gui;

import com.example.vaadintest.gui.generated.LoginForm;
import com.vaadin.terminal.UserError;

public class LoginFormImpl extends LoginForm  implements ILoginForm {
	public void resetInput(){
		getTxtBen().setValue(EMPTY);
		getPsw().setValue(EMPTY);
	}
	
	public void setBenError(){
		getTxtBen().setComponentError(new UserError("Bring bitte den Müll runter!"));
	}
	
	public void setPswError(){
		getPsw().setComponentError(new UserError("Mach die Musik leiser!"));
	}
	
	public void removeErrors(){
		getTxtBen().setComponentError(null);
		getPsw().setComponentError(null);
	}

	private final static String EMPTY="";

}
