package com.durgasoft.project.seleniumproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Loaddata_PropertiesFile
{
	public static String path = "./config.properties";
	
	public static void loaddata() throws IOException
	
	{ 
		Properties prop = new Properties();
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		prop.load(fis);
		
				
		
		
	}

}
