package com.google.commons;

import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

	static private Properties props;

	private static void readProperties() {
		if (props != null) {
			return;
		}

		props = new Properties();

		try (InputStream myIs = TestProperties.class.getResourceAsStream("/config/config.properties")) {
			props.load(myIs);

		} catch (Exception e) {
			throw new RuntimeException(e);
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
