package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class LoadProperties {
	static String propertiesfilePath="\\src\\main\\java\\properties\\userData.Properties";
	
	public static Properties userData= loaProperties(System.getProperty("user.dir")+propertiesfilePath);
	
	private static Properties loaProperties(String path) {
		
		Properties pro = new Properties();
		try {
			//stream for read file 
			FileInputStream stream= new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error occured "+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occured "+ e.getMessage());
		}
		return pro;
		
	
	}
	

}
