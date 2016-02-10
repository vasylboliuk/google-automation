package com.google.commons;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

	static Properties props;
	static FileInputStream in;

	private static void readProperties() {
		if (props != null) {
			return;
		}

		props = new Properties();

		try {
			InputStream myIs = TestProperties.class.getResourceAsStream("/config/config.properties");
			props.load(myIs);
			myIs.close();
			// in = new
			// FileInputStream("src/main/resources/config/config.properties");
			// props.load(in);
			// in.close();
		} catch (Exception e) {
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
