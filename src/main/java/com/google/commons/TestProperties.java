package com.google.commons;


import java.io.FileInputStream;
import java.util.Properties;

public class TestProperties {
	
	static Properties props;
	static FileInputStream in;
	
	public static void readProperties() {
		props = new Properties();
		
	try{
		in = new FileInputStream("src/main/resources/config/config.properties");
		props.load(in);
		in.close();
	}catch(Exception e){
		e.printStackTrace();	
		}
	}
	
	public static String getGooglePageUrl() {
		readProperties();
		return props.getProperty("ENG_GOOGLE_PAGE_URL");
	}
	
	public static int getWaiterTimeout() {
		readProperties();
		return Integer.valueOf(props.getProperty("WAITERS_TIMEOUT"));
	}
		
}
