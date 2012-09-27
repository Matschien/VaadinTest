package com.example.vaadintest.gui;

import com.vaadin.terminal.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public interface ILoginForm {
	void resetInput();
	void setBenError();
	void setPswError();
	void removeErrors();
	Button getAnmelden();
	Button getAbbrechen();
	TextField getTxtBen();
	PasswordField getPsw();
	Window getWindow();
	void loginBeenden();
	void center();
}
