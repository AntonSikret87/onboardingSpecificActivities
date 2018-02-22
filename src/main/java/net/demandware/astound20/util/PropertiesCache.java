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
		InputStream inLocatorsAstound = this.getClass().getClassLoader().getResourceAsStream(
				"selectorsAstound.properties");
		InputStream inConfigAstound = this.getClass().getClassLoader().getResourceAsStream("configAstound.properties");
		InputStream inConfigPropGmail = this.getClass().getClassLoader().getResourceAsStream("configGmail.properties");
		InputStream inLocatorsGmail = this.getClass().getClassLoader().getResourceAsStream("selectorsGmail" +
		                                                                                   ".properties");
		InputStream inDataGmail = this.getClass().getClassLoader().getResourceAsStream("dataGmail.properties");
		try {
			configProp.load(inConfigAstound);
			configProp.load(inLocatorsAstound);
			configProp.load(inConfigPropGmail);
			configProp.load(inLocatorsGmail);
			configProp.load(inDataGmail);
		} catch (IOException e) {
			System.out.println("Cant read all properties from file. Exeprion: " + e);
		}
	}

	public static String getProperty(String key) {
		return INSTANCE.configProp.getProperty(key);
	}
}
