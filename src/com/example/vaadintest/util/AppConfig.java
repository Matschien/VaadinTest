package com.example.vaadintest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.ConfigurationException;

public class AppConfig {
	private static AppConfig inst=null;
	private static Properties propFile=null;
	Logger log = Logger.getLogger( AppConfig.class.getName() );
	FileHandler handler = new FileHandler("log.txt");
	private String logDatei ="";
	
	private AppConfig() throws SecurityException, IOException {
		handler.setLevel( Level.FINEST );
		log.addHandler( handler );
		log.setLevel( Level.FINEST );
	}
	
	public static void createInst(String pathToCfgFile) throws ConfigurationException, IOException {
		inst=new AppConfig();
		// ... irgend etwas zur Initialisierung tun
		File f=new File(pathToCfgFile);
		if (!f.exists())
			throw new ConfigurationException("Conf-file does not exist: "+pathToCfgFile);
		if (!f.isFile())
			throw new ConfigurationException("Conf-file is not a file: "+pathToCfgFile);
		propFile=new Properties();
		propFile.load(new FileInputStream(f));
	}
	
	public static AppConfig getInst() throws ConfigurationException {
		if (inst==null)
			throw new ConfigurationException("Conf-object is not created");
		return inst;
	}
	

	public String getConfStrValue(String key,String defaultValue) throws ConfigurationException {
		try {
			String s=(String)propFile.get(key);
			if (s==null)
				return defaultValue;
			return s;
		}
		catch(Exception e) {
			log.log( Level.SEVERE, "Conf-file does not exist!", e );
			return defaultValue;
		} 
	}

	public int getConfNumValue(String key,int defaultValue) throws ConfigurationException {
		// auslesen der Konfiguration ...
		try {
			String s=(String)propFile.get(key);
			if (s==null)
				return defaultValue;
			return Integer.parseInt(s);
		}
		catch(Exception e) {
			log.log( Level.SEVERE, "Conf-file does not exist!", e );
			return defaultValue;
		}
	}
}
