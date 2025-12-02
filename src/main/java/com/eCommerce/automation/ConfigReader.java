package com.eCommerce.automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {
	  public static Properties loadProperties(String fileName) throws IOException {
		  
		
	        String filePath = System.getProperty("user.dir") + "/src/test/resources/" + fileName;

			 Properties prop = new Properties();
	        try (FileInputStream fis = new FileInputStream(filePath)) {
	            prop.load(fis);

	        } catch (IOException e) {
	        	 throw new IOException("Failed to load properties file: " + fileName, e);

	        }

	        return prop;}}