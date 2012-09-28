package com.example.vaadintest.gui;

import java.io.IOException;

import javax.naming.ConfigurationException;

public interface ILoginFormListener {
	void loginOkay(String benID) throws IOException;
	void loginCanceled();
	void loginDenied();
}
