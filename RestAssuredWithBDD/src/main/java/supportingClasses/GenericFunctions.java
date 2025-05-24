package supportingClasses;

import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.Properties;

public class GenericFunctions {
	
	//Function to get current TimeStamp
	public static String getTimestamp() {
		Long date = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(date);
		String strDate = timestamp.toString();
		return strDate;
	}
	
	// Function to read a property value from global properties file
	public static String getPropertyValue(String key) throws Exception{
		String value = null;
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(".//src//main//java//globalProperties//global.properties");
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
