package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLibrary implements FrameWorkConstant {
	
	
static	FileInputStream fis;
static FileOutputStream fos;
static Properties property;

public static String readData(String key) {
	
	// 1. Convert External File into Java Understandable

			
			try {
				fis = new FileInputStream(propertypath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 2  crate an object for properties file
			property = new Properties();
			
			//3 load all the property 
			try {
				property.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//4 read/fetch the data
			String  data = property.getProperty(key);
			
			return property.getProperty(key);
			//return data;
			

}

public static void writeData(String newKey, String newData, String message)  {
	
	// 1. Convert External File into Java Understandable

	try {
		fis = new FileInputStream(propertypath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// 2  crate an object for properties file
 property = new Properties();
	
	//3 load all the property 
	try {
		property.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//4 put the new data in properties file
	
	property.put(newKey, newData);
	
	//convert the java understandable in to external file
	
	try {
		fos = new FileOutputStream(propertypath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//6 store the new data with message
	try {
		property.store(fos, message);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

