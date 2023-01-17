package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class ReadProperties {
	
static Properties prop = new Properties();
	
	public static String getData(String key) throws Exception
	{
		String path = "\\src\\test\\resources\\config.properties";
		String filepath = System.getProperty("user.dir")+path;
		
		FileInputStream fis = new FileInputStream(filepath);
		prop.load(fis);
		String value = prop.getProperty(key);
		if(StringUtils.isEmpty(value)) {
			throw new Exception("Value not specified in key:" +key+ "in properties file");
		}
		return value;
		
	}

}
