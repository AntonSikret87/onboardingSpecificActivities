package net.demandware.astound20.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCache {
	private final Properties configProp = new Properties();
	private static final PropertiesCache INSTANCE = new PropertiesCache();

	private PropertiesCache() {
		//Private constructor to restrict new instances
		System.out.println("Read all properties from file ");
		InputStream inConfigProp = this.getClass().getClassLoader().getResourceAsStream("test.properties");
		InputStream inTestLocatorsData = this.getClass().getClassLoader().getResourceAsStream("config.properties");
		InputStream inConfigPropGmail = this.getClass().getClassLoader().getResourceAsStream("configGmail.properties");
		InputStream inTestLocatorsDataGmail = this.getClass().getClassLoader().getResourceAsStream("data_and_selectorsGmail.properties");
		try {
			configProp.load(inConfigProp);
			configProp.load(inTestLocatorsData);
			configProp.load(inConfigPropGmail);
			configProp.load(inTestLocatorsDataGmail);
		} catch (IOException e) {
			System.out.println("Cant read all properties from file. Exeprion: " + e);
		}
	}

	public static String getProperty(String key) {
		return INSTANCE.configProp.getProperty(key);
	}
}
