package com.example.vaadintest.gui.generated;
import com.vaadin.ui.Table;

public class VerlaufList extends Table{
	public VerlaufList(){
		setSizeFull();
		setStyleName("verlaufList");
		addContainerProperty("First Name", String.class, "Mark");
		addContainerProperty("Last Name", String.class, "Smith");
		addItem();
		addItem();
	}
}
