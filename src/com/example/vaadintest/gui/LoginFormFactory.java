package com.example.vaadintest.gui;

public class LoginFormFactory {
	public static ILoginForm createLoginForm() {
		return new LoginFormImpl();			
	}
}
