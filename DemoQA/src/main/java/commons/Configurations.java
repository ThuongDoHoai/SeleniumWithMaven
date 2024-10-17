package commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class Configurations {

	String configFile;

	public Configurations(String configFile) {
		this.configFile = configFile;
	}

	public String getConfigValueByKey(String configName) {
		String configValue = "";
		try {
			InputStream reader = new FileInputStream(configFile);
			Properties prop = new Properties();
			prop.load(reader);
			configValue = prop.getProperty(configName);
		} catch (Exception e) {
			System.out.println("File not found!");
		}
		return configValue;
	}

}
