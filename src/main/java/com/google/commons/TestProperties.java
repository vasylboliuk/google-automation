package com.google.commons;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	
	static final Properties props = new Properties();
	static {
		InputStream is = TestProperties.class.getResourceAsStream("config/config.properties");
		try {
			props.load(is);
			is.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static final String GOOGLE_PAGE_URL = props.getProperty("GOOGLE_PAGE_URL");
	public static final String ENG_GOOGLE_PAGE_URL = props.getProperty("ENG_GOOGLE_PAGE_URL");
	public static final long WAITERS_TIMEOUT = Long.valueOf(props.getProperty("WAITERS_TIMEOUT"));
	public static final String PATH_TO_FIREFOX_34 = props.getProperty("c:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); //Firefox 34.0.5
	public static final String PATH_TO_FIREFOX_43 = props.getProperty("c:\\Program Files\\Mozilla Firefox\\firefox.exe"); //Firefox 43.0.4
	
	
//	public static String getProp(String propName) {
//		return props.getProperty(propName);
//	}
}
