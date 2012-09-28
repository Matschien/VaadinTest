package com.example.vaadintest.gui;

import javax.naming.ConfigurationException;

public class LoginFormFactory {
	public static ILoginForm createLoginForm(ILoginFormListener listener) throws ConfigurationException {
		return new LoginFormImpl(listener);			
	}
}
